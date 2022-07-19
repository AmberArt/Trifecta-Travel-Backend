package com.trifectatravel.travel_api.controllers;


import com.trifectatravel.travel_api.controllers.dto.PurchaseOrderDTO;
import com.trifectatravel.travel_api.repositories.entities.Customer;
import com.trifectatravel.travel_api.repositories.entities.PurchaseOrder;
import com.trifectatravel.travel_api.service.CustomerService;
import com.trifectatravel.travel_api.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class PurchaseOrderController {

    private final PurchaseOrderService purchaseOrderService;
    private final CustomerService customerService;

    public PurchaseOrderController( PurchaseOrderService purchaseOrderService, CustomerService customerService){
        this.purchaseOrderService = purchaseOrderService;
        this.customerService = customerService;
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
    public PurchaseOrder createNewOrder(@RequestBody Customer customer, @PathVariable("id") Integer packageId){
        Customer customerSaved = customerService.save(customer);
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO(packageId, customerSaved.getId());
        return purchaseOrderService.save(purchaseOrderDTO);
    }

//    @PutMapping("/{id}")
//    public PurchaseOrder updateOrder(@PathVariable("id") Integer orderId, PurchaseOrderDTO purchaseOrderDTO){
//        return purchaseOrderService.update(orderId, purchaseOrderDTO);
//    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Integer orderId){
        purchaseOrderService.delete(orderId);
    }
}
