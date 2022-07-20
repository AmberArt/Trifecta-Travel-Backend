package com.trifectatravel.travel_api.service;

import com.trifectatravel.travel_api.controllers.PurchaseOrderController;
import com.trifectatravel.travel_api.controllers.dto.PurchaseOrderDTO;
import com.trifectatravel.travel_api.controllers.dto.TravelPackageDTO;
import com.trifectatravel.travel_api.repositories.PurchaseOrderRepository;
import com.trifectatravel.travel_api.repositories.entities.PurchaseOrder;
import com.trifectatravel.travel_api.repositories.entities.TravelPackage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    private PurchaseOrderRepository purchaseOrderRepository;
    private TravelPackageDTO travelPackageDTO;

    public PurchaseOrderServiceImpl(final PurchaseOrderRepository purchaseOrderRepository){
         this.purchaseOrderRepository = purchaseOrderRepository;
     }

    @Override
    public PurchaseOrder save(PurchaseOrderDTO purchaseOrderDTO) {
         PurchaseOrder purchaseOrder = new PurchaseOrder(purchaseOrderDTO);
         return purchaseOrderRepository.save(purchaseOrder);
    }

//    TODO: adding update to already purchased order if info was wrong
//    @Override
//    public PurchaseOrder update(Integer orderId, PurchaseOrderDTO purchaseOrderDTO) {
//        Optional<PurchaseOrder> purchaseOrderOptional = purchaseOrderRepository.findById(orderId);
//        if(purchaseOrderOptional.isEmpty()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with %d not found".formatted(orderId));
//        }
//        return purchaseOrderRepository.save(orderToUpdate);
//    }

    @Override
    public void delete(Integer orderId) {
        Optional<PurchaseOrder> purchaseOrderOptional = purchaseOrderRepository.findById(orderId);
        if(purchaseOrderOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with %d not found".formatted(orderId));
        }

        PurchaseOrder orderToDelete = purchaseOrderOptional.get();
        purchaseOrderRepository.delete(orderToDelete);
    }

    @Override
    public Iterable<PurchaseOrder> findAll() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public PurchaseOrder findById(Integer orderId) {
        Optional<PurchaseOrder> purchaseOrderOptional = purchaseOrderRepository.findById(orderId);
        if(purchaseOrderOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Order with %d not found".formatted(orderId));
        }

        PurchaseOrder purchaseOrder = purchaseOrderOptional.get();
        return purchaseOrder;
    }

    @Override
    public void assignTravelPackage(TravelPackage travelPackage) {
//        this.travelPackageDTO = travelPackageDTO;
//        return purchaseOrderRepository.save(purchaseOrder);
    }
}
