package com.trifectatravel.travel_api.controllers;

import com.trifectatravel.travel_api.controllers.dto.TravelPackageDTO;
import com.trifectatravel.travel_api.repositories.entities.TravelPackage;
import com.trifectatravel.travel_api.repositories.TravelPackageRepository;
import com.trifectatravel.travel_api.service.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/travelpackage")
//http://127.0.0.1:5500
@CrossOrigin( origins = "http://127.0.0.1:5500")
public class TravelPackageController {


    private TravelPackageService travelPackageService;

    public TravelPackageController(final TravelPackageService travelPackageService){
        this.travelPackageService = travelPackageService;
    }

    @GetMapping
    public Iterable<TravelPackage> getAllTravelPackages() {
        return this.travelPackageService.findAll();
    }

    // curl localhost:4001/travelpackage/2
    @GetMapping("/{id}")
    public TravelPackage getTravelPackageById(@PathVariable("id") Integer packageId) { return this.travelPackageService.findById(packageId); }

    // curl -X POST -d '{"name": "TravisPlant", "quantity": 3, "wateringFrequency": 5, "hasFruit": true}' -H "Content-Type:application/json" localhost:4001/plants
    @PostMapping("/add")
    public TravelPackage createNewTravelPackage(@RequestBody TravelPackageDTO travelPackageDTO) {
        return this.travelPackageService.save(travelPackageDTO);
    }

//    curl -X PUT -d '{"quantity": 36, "wateringFrequency": 3}' -H "Content-Type:application/json" localhost:4001/plants/2
    @PutMapping("/{id}")
    public TravelPackage updateTravelPackage(@PathVariable("id") Integer packageId, @RequestBody TravelPackageDTO travelPackageDTO){
        return travelPackageService.update(packageId, travelPackageDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTravelPackage(@PathVariable("id") Integer packageId) {
      travelPackageService.delete(packageId);
    }

}
