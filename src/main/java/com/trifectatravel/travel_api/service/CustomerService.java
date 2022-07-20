package com.trifectatravel.travel_api.service;

import com.trifectatravel.travel_api.controllers.dto.PurchaseOrderDTO;
import com.trifectatravel.travel_api.repositories.entities.Customer;
import com.trifectatravel.travel_api.repositories.entities.PurchaseOrder;

public interface CustomerService {

    Customer save(Customer customer);

//    Customer update(Integer orderId, PurchaseOrderDTO purchaseOrderDTO);
//
//    void delete(Integer orderId);
//
//    Iterable<PurchaseOrder> findAll();
//
    Customer findById(Integer customerId);
}
