package com.example.apirest.controller;

import com.example.apirest.model.Race;
import com.example.apirest.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RaceRestController {

    private final RaceService raceService;

    @Autowired
    public RaceRestController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/races")
    public ResponseEntity<List<Race>> getAll(){
        return ResponseEntity.ok(raceService.getAllRaces());
    }

    @GetMapping("/races/{raceid}")
    public ResponseEntity<Race> getByRaceid(@PathVariable Long raceid){
        return this.raceService.getRaceByRaceid(raceid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/races")
    public ResponseEntity<Race> create(@RequestBody Race race){
        if (race.getRaceid() != null) {
            return ResponseEntity.badRequest().build();
        }
        this.raceService.saveRace(race);
        return ResponseEntity.ok(race);
    }

    @PutMapping("/races")
    ResponseEntity<Race> update(@RequestBody Race race){
        this.raceService.saveRace(race);
        return ResponseEntity.ok(race);
    }

    @DeleteMapping("/drivers/{raceid}")
    public ResponseEntity<Race> deleteByRaceid(@PathVariable Long raceid){
        this.raceService.deleteRaceByRaceid(raceid);
        return ResponseEntity.noContent().build();
    }

}
