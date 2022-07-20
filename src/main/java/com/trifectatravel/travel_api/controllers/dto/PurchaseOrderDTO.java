package com.trifectatravel.travel_api.controllers.dto;

import javax.persistence.Column;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Random;

public class PurchaseOrderDTO {

    private Integer travelPackageId;
    private Integer customerId;
    private String confirmationCode = alphaNumericString(15);

    public PurchaseOrderDTO(Integer travelPackageId, Integer customerId) {
        this.travelPackageId = travelPackageId;
        this.customerId = customerId;
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

    public String alphaNumericString(int len) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }
}
