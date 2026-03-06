package app.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trip {

    private Long id;
    private String title;
    private double budget;
    private boolean active;
    private List<Place> places = new ArrayList<>();

    public Trip(String title, double budget) {
        this.title = title;
        this.budget = budget;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Place> getPlaces() {
        return places;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Double.compare(budget, trip.budget) == 0 && active == trip.active && Objects.equals(id, trip.id) && Objects.equals(title, trip.title) && Objects.equals(places, trip.places);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, budget, active, places);
    }

    @Override
    public String toString() {
        return String.format("Trip: id -%d, title - %s, budget - %.2f, active - %b, place - %s",
                id, title, budget, active, places);
    }
}
