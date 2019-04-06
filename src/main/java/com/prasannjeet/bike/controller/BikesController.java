package com.prasannjeet.bike.controller;

import com.prasannjeet.bike.models.Bike;
import com.prasannjeet.bike.repository.BikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bikes")
public class BikesController {

    private final BikesRepository bikesRepository;

    @Autowired
    public BikesController(BikesRepository bikesRepository) {
        this.bikesRepository = bikesRepository;
    }

    @GetMapping
    @RequestMapping(value = "/all")
    public List<Bike> list() {
        return bikesRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "/{name}")
    public Bike getOne(@PathVariable String name) {
        return bikesRepository.findOneByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity.BodyBuilder create (@RequestBody Bike bike) {
        bikesRepository.save(bike);
//        return "Added new bike with name: "+bike.getName();
        return ResponseEntity.ok();
    }

//    public Bike get(@PathVariable("id") long id) {
//        return new Bike();
//    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String update (@RequestBody Bike bike) {
        bikesRepository.save(bike);
        return "Updated";
    }

    @DeleteMapping
    @RequestMapping(value = "{/id}")
    public String delete (@PathVariable String id) {
        bikesRepository.deleteById(id);
        return "Deleted!";
    }
}
