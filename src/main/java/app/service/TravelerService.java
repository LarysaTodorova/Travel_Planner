package app.service;

import app.repository.TravelerRepository;

public class TravelerService {

    private final TravelerRepository travelerRepository = new TravelerRepository();
    private final TripService tripService = TripService.getInstance();

}
