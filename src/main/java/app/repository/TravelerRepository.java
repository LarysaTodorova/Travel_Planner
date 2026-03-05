package app.repository;

import app.domain.Traveler;

import java.util.HashMap;
import java.util.Map;

public class TravelerRepository {

    private final Map<Long, Traveler> database = new HashMap<>();
}
