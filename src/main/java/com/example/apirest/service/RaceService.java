package com.example.apirest.service;

import com.example.apirest.model.Race;

import java.util.List;
import java.util.Optional;

public interface RaceService {

    List<Race> getAllRaces();
    Optional<Race> getRaceByRaceid(Long raceid);
    void deleteRaceByRaceid(Long raceid);
    void saveRace(Race race);

}
