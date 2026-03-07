package app.repository;

import app.domain.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripRepository {

    private final List<Trip> database = new ArrayList<>();

    private long maxId;

    public Trip save(Trip trip) {
        trip.setId(++maxId);
        database.add(trip);
        return trip;
    }

    public List<Trip> findAll() {
        return database;
    }

    public Trip findById(Long id) {
        for (Trip trip : database) {
            if (id.equals(trip.getId())) {
                return trip;
            }
        }
        return null;
    }

    public Trip findByTitle(String title) {
        for (Trip trip : database) {
            if (trip.getTitle().equalsIgnoreCase(title)) {
                return trip;
            }
        }
        return null;
    }

    public void updateTitle(Long id, String newTitle) {
        Trip tripForUpdate = findById(id);
        if (tripForUpdate != null) {
            tripForUpdate.setTitle(newTitle);
        }
    }

    public void updateBudget(Long id, double newBudget) {
        Trip tripForUpdate = findById(id);
        if (tripForUpdate != null) {
            tripForUpdate.setBudget(newBudget);
        }
    }

    public void remove(Long id) {
        Trip tripForDelete = findById(id);
        if (tripForDelete != null) {
            database.remove(tripForDelete);
        }
    }

}
