package com.example.apirest.service;

import com.example.apirest.model.Race;
import com.example.apirest.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceServiceImpl implements RaceService{

    private final RaceRepository repository;

    @Autowired
    public RaceServiceImpl(RaceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Race> getAllRaces() {
        return repository.findAll();
    }

    @Override
    public Optional<Race> getRaceByRaceid(Long raceid) {
        return repository.findByRaceid(raceid);
    }

    @Override
    public void deleteRaceByRaceid(Long raceid) {
        repository.removeByRaceid(raceid);
    }

    @Override
    public void saveRace(Race race) {
        repository.save(race);
    }
}
