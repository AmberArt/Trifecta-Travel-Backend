package com.trifectatravel.travel_api.repositories.entities;

import com.trifectatravel.travel_api.controllers.dto.PurchaseOrderDTO;

import javax.persistence.*;

@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    private Integer travelPackageId;
    private Integer customerId;
    private String confirmationCode;

    public PurchaseOrder(){

    }
    public PurchaseOrder(PurchaseOrderDTO purchaseOrderDTO) {
        this.travelPackageId = purchaseOrderDTO.getTravelPackageId();
        this.customerId = purchaseOrderDTO.getCustomerId();
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
}
