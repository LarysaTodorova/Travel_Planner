package app.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trip {

    private long id;
    private String title;
    private double budget;
    private boolean active;
    private List<Place> places = new ArrayList<>();

    public Trip(String title, double budget) {
        this.title = title;
        this.budget = budget;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return id == trip.id && Double.compare(budget, trip.budget) == 0 && active == trip.active && Objects.equals(title, trip.title) && Objects.equals(places, trip.places);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, budget, active, places);
    }

    @Override
    public String toString() {
        return String.format("Trip: id -%d, title - %s, budget - %.2f, active - %b", id, title, budget, active);
    }
}
