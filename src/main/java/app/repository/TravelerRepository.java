package app.repository;

import app.domain.Traveler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TravelerRepository {

    private final Map<Long, Traveler> database = new HashMap<>();

    private long maxId;

    public Traveler save(Traveler traveler) {
        traveler.setId(++maxId);
        database.put(maxId, traveler);
        return traveler;
    }

    public List<Traveler> findAll() {
        return new ArrayList<>(database.values());
    }

    public Traveler findById(Long id) {
        return database.get(id);
    }

    public void update(Long id, String name) {
        Traveler travelerForUpdate = database.get(id);
        if (travelerForUpdate != null) {
            travelerForUpdate.setName(name);
        }
    }

    public void delete(Long id) {
        database.remove(id);
    }
}
