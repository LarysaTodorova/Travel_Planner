package app.controller;

import app.domain.Trip;
import app.service.TripService;

import java.util.List;

public class TripController {

    private final TripService tripService = TripService.getInstance();

    public Trip save(String title, String budget) {
        double numericBudget = Double.parseDouble(budget);
        Trip trip = new Trip(title, numericBudget);
        return tripService.save(trip);
    }

    public List<Trip> findAllActiveTrips() {
        return tripService.findAllActiveTrips();
    }

    public Trip findById(String id) {
        Long numericId = Long.parseLong(id);
        return tripService.findById(numericId);
    }

    public Trip findActiveTripById(String id) {
        Long numericId = Long.parseLong(id);
        return tripService.findActiveTripById(numericId);
    }

    public Trip findByTitle(String title) {
        return tripService.findByTitle(title);
    }

    public void updateTripTitle(String id, String newTitle) {
        Long numericId = Long.parseLong(id);
        tripService.updateTripTitle(numericId, newTitle);
    }

    public void updateTripBudget(String id, String newBudget) {
        Long numericId = Long.parseLong(id);
        double numericBudget = Double.parseDouble(newBudget);
        tripService.updateTripBudget(numericId, numericBudget);
    }

    public void removeById(String id) {
        Long numericId = Long.parseLong(id);
        tripService.removeById(numericId);
    }

    public void removeByTitle(String title) {
        tripService.removeByTitle(title);
    }

    public void restoreTripById(String id) {
        Long numericId = Long.parseLong(id);
        tripService.restoreTripById(numericId);
    }

    public void addPlaceToTrip(String tripId, String placeId) {
        Long numericTripId = Long.parseLong(tripId);
        Long numericPlaceId = Long.parseLong(placeId);
        tripService.addPlaceToTrip(numericTripId, numericPlaceId);
    }

    public void removePlaceFromTrip(String tripId, String placeId) {
        Long numericTripId = Long.parseLong(tripId);
        Long numericPlaceId = Long.parseLong(placeId);
        tripService.removePlaceFromTrip(numericTripId, numericPlaceId);
    }
}
