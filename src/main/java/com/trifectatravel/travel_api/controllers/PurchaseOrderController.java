package com.trifectatravel.travel_api.controllers;


import com.trifectatravel.travel_api.controllers.dto.PurchaseOrderDTO;
import com.trifectatravel.travel_api.controllers.dto.TravelPackageDTO;
import com.trifectatravel.travel_api.repositories.entities.Customer;
import com.trifectatravel.travel_api.repositories.entities.PurchaseOrder;
import com.trifectatravel.travel_api.repositories.entities.TravelPackage;
import com.trifectatravel.travel_api.service.CustomerService;
import com.trifectatravel.travel_api.service.PurchaseOrderService;
import com.trifectatravel.travel_api.service.TravelPackageService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;
    private final CustomerService customerService;

    private final TravelPackageService travelPackageService;

    public PurchaseOrderController(PurchaseOrderService purchaseOrderService, CustomerService customerService, TravelPackageService travelPackageService){
        this.purchaseOrderService = purchaseOrderService;
        this.customerService = customerService;
        this.travelPackageService = travelPackageService;
    }

    @GetMapping
    public Iterable<PurchaseOrder> getAllTravelPackages() {
        return this.purchaseOrderService.findAll();
    }

    @GetMapping("/{id}")
    public PurchaseOrder getOrderById(@PathVariable("id") Integer orderId){
        return purchaseOrderService.findById(orderId);
    }

//    Customer created here. No need for controller since we don't have a sign in where they can interact with a profile
    @PostMapping("/add/{id}")
    public void createNewOrder(@RequestBody Customer customer, @PathVariable("id") Integer packageId){
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO(packageId);
//        first step: create customer in database
//        - then find customer by Id
//        -
        Customer customerSaved = customerService.save(customer);
        PurchaseOrder purchaseOrderSaved = purchaseOrderService.save(purchaseOrderDTO);
//        customerSaved.addOrder(purchaseOrderService.save(purchaseOrderDTO));
        purchaseOrderSaved.addTravelPackage(travelPackageService.findById(packageId));
        customerSaved.addOrder(purchaseOrderSaved);
        customerService.save(customerSaved);

    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable("id") Integer customerId ){
        return customerService.findById(customerId);
    }

//    get purchase order by customer
    @GetMapping("/id/{id}")
    public List<PurchaseOrder> getId(@PathVariable("id") final Integer id) {
        Customer customer = customerService.findById(id);
        return customer.getPurchaseOrders();
    }

//    @PutMapping("/{purchaseOrderId}/travelPackage/{travelPackageId}")
//    public PurchaseOrder assignTravelPackageToOrder(
//            @PathVariable Integer travelPackageId,
//            @PathVariable Integer purchaseOrderId
//    ) {
//        PurchaseOrderDTO purchaseOrderDTO = purchaseOrderService.findById(purchaseOrderId);
//        TravelPackage travelPackage = travelPackageService.findById(travelPackageId);
//        purchaseOrderService.assignTravelPackage(travelPackage);
//        return purchaseOrderService.save(purchaseOrder);
//    }


    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Integer orderId){
        purchaseOrderService.delete(orderId);
    }
}
