package com.trifectatravel.travel_api.repositories;

import com.trifectatravel.travel_api.repositories.entities.PurchaseOrder;
import com.trifectatravel.travel_api.repositories.entities.TravelPackage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Integer> {


}
