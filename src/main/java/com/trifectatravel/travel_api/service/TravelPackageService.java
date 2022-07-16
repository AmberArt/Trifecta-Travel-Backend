package com.trifectatravel.travel_api.service;

import com.trifectatravel.travel_api.controllers.dto.TravelPackageDTO;
import com.trifectatravel.travel_api.repositories.entities.TravelPackage;

public interface TravelPackageService {

    TravelPackage save(TravelPackageDTO travelPackageDTO);

    TravelPackage update(Integer id, TravelPackageDTO travelPackageDTO);

    void delete(Integer packageId);
    Iterable<TravelPackage> findAll();
    TravelPackage findById(Integer packageId);


}
