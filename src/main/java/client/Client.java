package client;

import app.domain.Place;
import app.domain.PlaceType;


public class Client {
    public static void main(String[] args) {

        Place place = new Place("Munich", "Englisher garden", PlaceType.PARK, 15.5);

        System.out.println(place);
    }
}
