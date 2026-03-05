package app.domain;

import java.util.Objects;

public class Place {

    private long id;
    private String city;
    private String name;
    private PlaceType placeType;
    private double estimatedCost;
    private boolean visited;

    public Place(String city, String name, PlaceType placeType, double estimatedCost) {
        this.city = city;
        this.name = name;
        this.placeType = placeType;
        this.estimatedCost = estimatedCost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return id == place.id && Double.compare(estimatedCost, place.estimatedCost) == 0 && visited == place.visited && Objects.equals(city, place.city) && Objects.equals(name, place.name) && placeType == place.placeType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, name, placeType, estimatedCost, visited);
    }

    @Override
    public String toString() {
        return String.format("Place: id - %d, city - %s, name - %s, type - %s, costs - %.2f, visited - %b",
                id, city, name, placeType, estimatedCost, visited);
    }
}
