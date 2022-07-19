package com.trifectatravel.travel_api.service;

import com.trifectatravel.travel_api.controllers.dto.PurchaseOrderDTO;
import com.trifectatravel.travel_api.repositories.entities.PurchaseOrder;

public interface PurchaseOrderService {

    PurchaseOrder save(PurchaseOrderDTO purchaseOrderDTO);

//    PurchaseOrder update(Integer orderId, PurchaseOrderDTO purchaseOrderDTO);

    void delete(Integer orderId);

    Iterable<PurchaseOrder> findAll();

    PurchaseOrder findById(Integer orderId);
}
