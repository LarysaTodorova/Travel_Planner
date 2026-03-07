package app.repository;

import app.domain.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceRepository {

    private final List<Place> database = new ArrayList<>();

    private long maxId;

    public Place save(Place place) {
        place.setId(++maxId);
        database.add(place);
        return place;
    }

    public List<Place> findAll() {
        return database;
    }

    public Place findById(Long id) {
        for (Place place : database) {
            if (place.getId().equals(id)) {
                return place;
            }
        }
        return null;
    }

    public Place findByName(String name) {
        for (Place place : database) {
            if (place.getName().equalsIgnoreCase(name)) {
                return place;
            }
        }
        return null;
    }

    public void update(Long id, double newCost) {
        Place placeForUpdate = findById(id);
        if (placeForUpdate != null) {
            placeForUpdate.setEstimatedCost(newCost);
        }
    }

    public void remove(Long id) {
        Place placeForDelete = findById(id);
        if (placeForDelete != null) {
            database.remove(placeForDelete);
        }
    }

}
