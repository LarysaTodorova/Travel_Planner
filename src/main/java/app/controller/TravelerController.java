package app.controller;

import app.domain.Traveler;
import app.service.TravelerService;

import java.util.List;

public class TravelerController {

    private final TravelerService travelerService = TravelerService.getInstance();

    public Traveler save(String name) {
        Traveler traveler = new Traveler(name);
        return travelerService.save(traveler);
    }

    public List<Traveler> findAllActiveTravelers() {
        return travelerService.findAllActiveTravelers();
    }

    public Traveler findById(String id) {
        Long numericId = Long.parseLong(id);
        return travelerService.findById(numericId);
    }

    public List<Traveler> findTravelerByName(String name) {
        return travelerService.findTravelerByName(name);
    }

    public void update(String id, String name) {
        Long numericId = Long.parseLong(id);
        travelerService.update(numericId, name);
    }

    public void addTripToTraveler(String travelerId, String tripId) {
        Long numericTravelerId = Long.parseLong(travelerId);
        Long numericTripId = Long.parseLong(tripId);
        travelerService.addTripToTraveler(numericTravelerId, numericTripId);
    }

    public void removeTraveler(String id) {
        Long numericId = Long.parseLong(id);
        travelerService.removeTraveler(numericId);
    }

    public void restoreTraveler(String id) {
        Long numericTravelerId = Long.parseLong(id);
        travelerService.restoreTraveler(numericTravelerId);
    }

    public void removeTripFromTraveler(String travelerId, String tripId) {
        Long numericTravelerId = Long.parseLong(travelerId);
        Long numericTripId = Long.parseLong(tripId);
        travelerService.removeTripFromTraveler(numericTravelerId, numericTripId);
    }

    public void removePlaceFromTravelersTrip(String travelerId, String tripId, String placeId) {
        Long numericTravelerId = Long.parseLong(travelerId);
        Long numericTripId = Long.parseLong(tripId);
        Long numericPlaceId = Long.parseLong(placeId);
        travelerService.removePlaceFromTravelersTrip(numericTravelerId, numericTripId, numericPlaceId);
    }
}
