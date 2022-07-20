package com.trifectatravel.travel_api.repositories.entities;

import com.trifectatravel.travel_api.controllers.dto.PurchaseOrderDTO;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "purchase_order")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_order_id", nullable = false, updatable = false)
    private Integer id;

//    private final static String travelPackagePrimaryIdName = "travel_package_id";
    @Column(name = "travel_package_id")
//    @Column(name = travelPackagePrimaryIdName)
    private Integer travelPackageId;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "confirmation_code")
    private String confirmationCode;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "travelPackage", referencedColumnName = "id")
//    private TravelPackage travelPackage;

//    @ManyToOne(mapped)
//    private Customer customer;

    public List<TravelPackage> getTravelPackages() {
        return travelPackages;
    }

    public void setTravelPackages(List<TravelPackage> travelPackages) {
        this.travelPackages = travelPackages;
    }

    @OneToMany
    @JoinColumn(name = "purchase_order_id", referencedColumnName = "purchase_order_id")
    private List<TravelPackage> travelPackages = new ArrayList<>();

    public PurchaseOrder(){

    }
    public PurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
        this.travelPackageId = purchaseOrderDTO.getTravelPackageId();
//        this.customerId = purchaseOrderDTO.getCustomerId();
        this.confirmationCode = purchaseOrderDTO.getConfirmationCode();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTravelPackageId() {
        return travelPackageId;
    }

    public void setTravelPackageId(Integer travelPackageId) {
        this.travelPackageId = travelPackageId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    public void addTravelPackage(TravelPackage travelPackage){
        travelPackages.add(travelPackage);
    }

//    @JoinColumn(name = "travel_package_id", referencedColumnName = "id")
//    public TravelPackage getTravelPackage() {
//        return travelPackage;
//    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

}
