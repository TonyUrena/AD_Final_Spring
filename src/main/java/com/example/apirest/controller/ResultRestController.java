package com.example.apirest.controller;

import com.example.apirest.model.Result;
import com.example.apirest.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResultRestController {

    private final ResultService resultService;

    @Autowired
    public ResultRestController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/results")
    public ResponseEntity<List<Result>> getAll(){return ResponseEntity.ok(resultService.getAllResults());}

    @GetMapping("/results/{resultid}")
    public ResponseEntity<Result> getByResultid(@PathVariable Long resultid){
        return this.resultService.getByResultid(resultid)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/results")
    public ResponseEntity<Result> create(@RequestBody Result result){
        if (result.getResultId() != null) {
            return ResponseEntity.badRequest().build();
        }
        this.resultService.saveResult(result);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/results")
    public ResponseEntity<Result> update(@RequestBody Result result){
        this.resultService.saveResult(result);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/results/{resultid}")
    public ResponseEntity<Result> deleteByResultid(@RequestBody Long result){
        this.resultService.deleteByResultid(result);
        return ResponseEntity.noContent().build();
    }
}
