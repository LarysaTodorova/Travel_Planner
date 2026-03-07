package app.controller;

import app.domain.Place;
import app.domain.PlaceType;
import app.service.PlaceService;

import java.util.List;

public class PlaceController {

    private final PlaceService placeService = PlaceService.getInstance();

    public Place save(String city, String name, PlaceType placeType, String estimatedCost) {
        double numericCost = Double.parseDouble(estimatedCost);
        Place place = new Place(city, name, placeType, numericCost);
        return placeService.save(place);
    }

    public List<Place> findAllNotVisitedPlaces() {
        return placeService.findAllNotVisitedPlaces();
    }

    public Place findById(String id) {
        Long numericId = Long.parseLong(id);
        return placeService.findById(numericId);
    }

    public Place findByName(String placeName) {
        return placeService.findByName(placeName);
    }

    public List<Place> findByCity(String city) {
        return placeService.findByCity(city);
    }

    public void markPlaceAsVisited(String id) {
        Long numericId = Long.parseLong(id);
        placeService.markPlaceAsVisited(numericId);
    }

    public void updatePlaceCost(String id, String cost) {
        Long numericId = Long.parseLong(id);
        Double numericCost = Double.parseDouble(cost);
        placeService.updatePlaceCost(numericId, numericCost);
    }

    public void  remove(String id) {
        Long numericId = Long.parseLong(id);
        placeService.remove(numericId);
    }

}
