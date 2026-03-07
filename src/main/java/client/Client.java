package client;

import app.domain.Place;
import app.domain.PlaceType;
import app.domain.Traveler;
import app.domain.Trip;
import app.service.PlaceService;
import app.service.TripService;


public class Client {
    public static void main(String[] args) {

        Place place = new Place("Munich", "Englisher garden", PlaceType.PARK, 15.5);
        PlaceService placeService = PlaceService.getInstance();
        placeService.save(place);
        System.out.println("Place has been saved successfully: " + place);

        Trip trip = new Trip("Walking", 26.7);
        TripService tripService = TripService.getInstance();
        tripService.save(trip);
        tripService.addPlaceToTrip(1L, 1L);
        System.out.println("New trip: " + trip);

        Traveler traveler = new Traveler("Alexa");
        System.out.println(traveler);
    }
}
