package app.service;

import app.domain.Place;
import app.domain.Trip;
import app.exception.*;
import app.repository.TripRepository;

import java.util.List;

public class TripService {

    private static TripService instance;
    private final TripRepository tripRepository = new TripRepository();
    private final PlaceService placeService = PlaceService.getInstance();

    private TripService() {

    }

    public static TripService getInstance() {
        if (instance == null) {
            instance = new TripService();
        }
        return instance;
    }

    public Trip save(Trip trip) {
        if (trip == null) {
            throw new TripSaveException("Trip can't be null");
        }

        if (trip.getTitle() == null || trip.getTitle().trim().isBlank()) {
            throw new TripSaveException("Title can't be null or empty");
        }

        if (trip.getBudget() < 0) {
            throw new TripSaveException("Budget can't be negative");
        }

        trip.setActive(true);
        return tripRepository.save(trip);
    }

    public List<Trip> findAllActiveTrips() {
        return tripRepository.findAll()
                .stream()
                .filter(Trip::isActive)
                .toList();
    }

    public Trip findById(Long id) {
        Trip trip = tripRepository.findById(id);

        if (trip == null) {
            throw new TripNotFoundException(id);
        }
        return trip;
    }

    public Trip findByTitle(String title) {
        Trip trip = tripRepository.findByTitle(title);

        if (trip == null) {
            throw new TripNotFoundByTitleException(title);
        }
        return trip;
    }

    public void updateTripTitle(Long id, String newTitle) {
        findById(id);

        if (newTitle == null || newTitle.trim().isBlank()) {
            throw new TripUpdateException("Title can't be null or empty");
        }

        tripRepository.updateTitle(id, newTitle);
    }

    public void updateTripBudget(Long id, double newBudget) {
        findById(id);

        if (newBudget < 0) {
            throw new TripUpdateException("Budget can't be negative");
        }
        tripRepository.updateBudget(id, newBudget);
    }

    public void deleteById(Long id) {
        Trip trip = findById(id);
        trip.setActive(false);
    }

    public void deleteByTitle(String title) {
        findByTitle(title);
        findAllActiveTrips()
                .stream()
                .filter(t -> t.getTitle().equalsIgnoreCase(title))
                .forEach(t -> t.setActive(false));
    }

    public void restoreById(Long id) {
        Trip trip = findById(id);
        trip.setActive(true);
    }

    public void addPlaceToTrip(Long tripId, Long placeId) {
        Place place = placeService.findById(placeId);
        Trip trip = findById(tripId);
        if (trip.getPlaces().contains(place)) {
            throw new TripUpdateException("Place already exists in this trip");
        }
        trip.getPlaces().add(place);
    }
}
