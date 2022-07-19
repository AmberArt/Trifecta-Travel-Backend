package com.trifectatravel.travel_api.service;

import com.trifectatravel.travel_api.controllers.dto.TravelPackageDTO;
import com.trifectatravel.travel_api.repositories.TravelPackageRepository;
import com.trifectatravel.travel_api.repositories.entities.TravelPackage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class TravelPackageServiceImpl implements TravelPackageService {

    private final TravelPackageRepository travelPackageRepository;

    public TravelPackageServiceImpl(TravelPackageRepository travelPackageRepository) {
        this.travelPackageRepository = travelPackageRepository;
    }

    @Override
    public TravelPackage save(TravelPackageDTO travelPackageDTO) {
        TravelPackage travelPackage = new TravelPackage(travelPackageDTO);
        return travelPackageRepository.save(travelPackage);
    }

    @Override
    public TravelPackage update(Integer id, TravelPackageDTO travelPackageDTO) {

        Optional<TravelPackage> packageToUpdateOptional = this.travelPackageRepository.findById(id);
        if (packageToUpdateOptional.isEmpty()) {
            return null;
        }

        TravelPackage packageToUpdate = packageToUpdateOptional.get();
        if (travelPackageDTO.getTripName() != null && !travelPackageDTO.getTripName().isEmpty()) {
            packageToUpdate.setTripName(travelPackageDTO.getTripName());
        }

        if (travelPackageDTO.getDescription() != null && !travelPackageDTO.getDescription().isEmpty()) {
            packageToUpdate.setDescription(travelPackageDTO.getDescription());
        }

        if (travelPackageDTO.getImageFilePath() != null && !travelPackageDTO.getImageFilePath().isEmpty()){
            packageToUpdate.setImageFilePath(travelPackageDTO.getImageFilePath());
        }

        return this.travelPackageRepository.save(packageToUpdate);
    }

    @Override
    public Iterable<TravelPackage> findAll() {
        return travelPackageRepository.findAll();
    }

    @Override
    public TravelPackage findById(Integer packageId) {
        Optional<TravelPackage> travelPackageOptional = travelPackageRepository.findById(packageId);
        if(travelPackageOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Travel package with ID %d not found.".formatted(packageId));
        }
        return travelPackageOptional.get();
    }

    @Override
    public void delete(Integer packageId) {
        Optional<TravelPackage> packageToDeleteOptional = travelPackageRepository.findById(packageId);
       if (packageToDeleteOptional.isEmpty()){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Travel package with ID %d not found".formatted(packageId));
       }

       TravelPackage packageToDelete = packageToDeleteOptional.get();
       travelPackageRepository.delete(packageToDelete);

    }


}
