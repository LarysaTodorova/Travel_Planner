package app.service;

import app.domain.Place;
import app.domain.Traveler;
import app.domain.Trip;
import app.exception.*;
import app.repository.TravelerRepository;

import java.util.List;

public class TravelerService {

    private final TravelerRepository travelerRepository = new TravelerRepository();
    private final TripService tripService = TripService.getInstance();
    private final PlaceService placeService = PlaceService.getInstance();

    public Traveler save(Traveler traveler) {
        if (traveler == null) {
            throw new TravelerSaveException("Traveler can't be null");
        }

        if (traveler.getName() == null || traveler.getName().trim().isBlank()) {
            throw new TravelerSaveException("Traveler name can't be null or empty");
        }

        traveler.setActive(true);
        travelerRepository.save(traveler);
        return traveler;
    }

    public List<Traveler> findAllActiveTravelers() {
        return travelerRepository.findAll()
                .stream()
                .filter(Traveler::isActive)
                .toList();
    }

    public Traveler findById(Long id) {
        Traveler traveler = travelerRepository.findById(id);

        if (traveler == null) {
            throw new TravelerNotFoundException(id);
        }
        return traveler;
    }

    public List<Traveler> findTravelerByName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new TravelerNotFoundByNameException("Traveler name can't be null");
        }

        List<Traveler> travelers = travelerRepository.findByName(name);

        if (travelers.isEmpty()) {
            throw new TravelerNotFoundByNameException("We have no traveler with such name");
        }
        return travelers;
    }

    public void update(Long id, String name) {
        findById(id);

        if (name == null || name.trim().isBlank()) {
            throw new TravelerUpdateException("Traveler name can't be null or empty");
        }
        travelerRepository.update(id, name);
    }

    public void addTripToTraveler(Long travelerId, Long tripId) {
        Trip trip = tripService.findActiveTripById(tripId);
        Traveler traveler = findById(travelerId);
        if (traveler.getTrips().contains(trip)) {
            throw new TripUpdateException("This trip already exists in Traveler");
        }
        traveler.getTrips().add(trip);
    }

    public void removeTraveler(Long id) {
        Traveler traveler = findById(id);
        if (traveler.isActive()) {
            traveler.setActive(false);
        }
    }

    public void restoreTraveler(Long id) {
        Traveler traveler = findById(id);
        if (!traveler.isActive()) {
            traveler.setActive(true);
        }
    }

    public void removeTripFromTraveler(Long travelerId, Long tripId) {
        Trip trip = tripService.findActiveTripById(tripId);
        Traveler traveler = findById(travelerId);

        if (traveler.getTrips().contains(trip)) {
            traveler.getTrips().remove(trip);
        } else {
            throw new TripNotFoundException(tripId);
        }
    }

    public void removePlaceFromTravelersTrip(Long travelerId, Long tripId, Long placeId) {
        Place place = placeService.findById(placeId);
        Trip trip = tripService.findActiveTripById(tripId);
        Traveler traveler = findById(travelerId);
        if (traveler.getTrips().contains(trip) && trip.getPlaces().contains(place)) {
            trip.getPlaces().remove(place);
        } else {
            throw new TripUpdateException("This place does not belong to this traveler's trip");
        }
    }
}
