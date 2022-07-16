package com.trifectatravel.travel_api.controllers.dto;

import javax.persistence.Column;

public class TravelPackageDTO {

    @Column(name = "trip_name")
    private String tripName;
    private String description;
    @Column(name = "image_file_path")
    private String imageFilePath;

    public TravelPackageDTO(){

    }

    public TravelPackageDTO(String tripName, String description, String imageFilePath) {

    }
    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageFilePath() {
        return imageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        this.imageFilePath = imageFilePath;
    }
}
