package app.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Traveler {

    private Long id;
    private String name;
    private boolean active;
    private List<Trip> trips = new ArrayList<>();

    public Traveler(String name) {
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Traveler traveler = (Traveler) o;
        return active == traveler.active && Objects.equals(id, traveler.id) && Objects.equals(name, traveler.name) && Objects.equals(trips, traveler.trips);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, active, trips);
    }

    @Override
    public String toString() {
        return String.format("Traveler: id -%d, name - %s, active - %b", id, name, active);
    }
}
