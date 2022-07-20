package com.trifectatravel.travel_api.service;

import com.trifectatravel.travel_api.controllers.dto.PurchaseOrderDTO;
import com.trifectatravel.travel_api.controllers.dto.TravelPackageDTO;
import com.trifectatravel.travel_api.repositories.entities.PurchaseOrder;
import com.trifectatravel.travel_api.repositories.entities.TravelPackage;

public interface PurchaseOrderService {

    PurchaseOrder save(PurchaseOrderDTO purchaseOrderDTO);

//    PurchaseOrder update(Integer orderId, PurchaseOrderDTO purchaseOrderDTO);

    void delete(Integer orderId);

    Iterable<PurchaseOrder> findAll();

    PurchaseOrder findById(Integer orderId);

    void assignTravelPackage(TravelPackage travelPackage);
}
