package client;

import app.domain.Place;
import app.domain.PlaceType;
import app.domain.Traveler;
import app.domain.Trip;


public class Client {
    public static void main(String[] args) {

        Place place = new Place("Munich", "Englisher garden", PlaceType.PARK, 15.5);
        System.out.println(place);

        Trip trip = new Trip("Walking", 26.7);
        System.out.println(trip);

        Traveler traveler = new Traveler("Alexa");
        System.out.println(traveler);
    }
}
