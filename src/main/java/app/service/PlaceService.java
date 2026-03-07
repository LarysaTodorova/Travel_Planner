package app.service;

import app.domain.Place;
import app.exception.PlaceNotFoundByNameException;
import app.exception.PlaceNotFoundException;
import app.exception.PlaceSaveException;
import app.exception.PlaceUpdateException;
import app.repository.PlaceRepository;

import java.util.List;

public class PlaceService {

    private static PlaceService instance;
    private final PlaceRepository placeRepository = new PlaceRepository();

    private PlaceService() {
    }

    public static PlaceService getInstance() {
        if (instance == null) {
            instance = new PlaceService();
        }
        return instance;
    }

    public Place save(Place place) {
        if (place == null) {
            throw new PlaceSaveException("Place can't be null");
        }

        if (place.getCity() == null || place.getCity().trim().isBlank()) {
            throw new PlaceSaveException("City can't be null or blank");
        }

        if (place.getName() == null || place.getName().trim().isBlank()) {
            throw new PlaceSaveException("Place name can't be null or blank");
        }

        if (place.getPlaceType() == null) {
            throw new PlaceSaveException("Place type can't be null");
        }

        if (place.getEstimatedCost() < 0) {
            throw new PlaceSaveException("Costs can't be less than 0");
        }

        return placeRepository.save(place);
    }

    public List<Place> findAllNotVisitedPlaces() {
        return placeRepository.findAll()
                .stream()
                .filter(p -> !p.isVisited())
                .toList();
    }

    public Place findById(Long id) {
        Place place = placeRepository.findById(id);

        if (place == null) {
            throw new PlaceNotFoundException(id);
        }
        return place;
    }

    public Place findByName(String name) {
        Place place = placeRepository.findByName(name);
        if (place == null) {
            throw new PlaceNotFoundByNameException(name);
        }
        return place;
    }

    public List<Place> findByCity(String city) {
        return placeRepository.findAll()
                .stream()
                .filter(p -> p.getCity().equalsIgnoreCase(city))
                .toList();
    }

    public void markPlaceAsVisited(Long id) {
        Place place = findById(id);
        place.setVisited(true);
    }

    public void updatePlaceCost(Long id, Double cost) {
        if (cost == null || cost < 0) {
            throw new PlaceUpdateException("Costs can't be less than 0");
        }
        findById(id);
        placeRepository.update(id, cost);
    }

    public void remove(Long id) {
        findById(id);
        placeRepository.delete(id);
    }

}
