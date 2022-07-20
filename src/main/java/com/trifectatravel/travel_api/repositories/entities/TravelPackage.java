package com.trifectatravel.travel_api.repositories.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trifectatravel.travel_api.controllers.dto.TravelPackageDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "travel_package")
public class TravelPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;
    @Column(name = "trip_name")
    private String tripName;
    private String description;
    @Column(name = "image_file_path")
    private String imageFilePath;



    @Column(name = "purchase_order_id")
    private Integer purchaseOrderId;

//    @JsonIgnore
//    @OneToMany(mappedBy = "travelPackage")
//    private Set<PurchaseOrder> purchaseOrders = new HashSet<>();


    public TravelPackage(TravelPackageDTO travelPackageDTO){
        this.setTripName(travelPackageDTO.getTripName());
        this.setDescription(travelPackageDTO.getDescription());
        this.setImageFilePath(travelPackageDTO.getImageFilePath());

    }

    public TravelPackage() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Integer purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

//    public Set<PurchaseOrder> getPurchaseOrders() {
//        return purchaseOrders;
//    }
}
