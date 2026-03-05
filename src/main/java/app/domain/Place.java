package app.domain;

import java.util.Objects;

public class Place {

    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return Double.compare(estimatedCost, place.estimatedCost) == 0 && visited == place.visited && Objects.equals(id, place.id) && Objects.equals(city, place.city) && Objects.equals(name, place.name) && placeType == place.placeType;
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
