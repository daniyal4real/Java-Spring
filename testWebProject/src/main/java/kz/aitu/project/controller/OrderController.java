package kz.aitu.project.controller;


import kz.aitu.project.entity.OrderItem;
import kz.aitu.project.service.OrderItemService;
import kz.aitu.project.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;
    private OrderItemService orderItemService;

    @GetMapping("/api/orders")
    public ResponseEntity<?> getAllOrders(){
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/api/factory/orders")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/api/orders/{orderId}")
    public ResponseEntity<?> getOrderById(@PathVariable long orderId){
        return ResponseEntity.ok(orderService.getById(orderId));
    }

    @PostMapping("/api/orders/create")
    public void create(@RequestHeader("Authorization") String token, @RequestBody List<OrderItem> orderItem){
       orderItemService.create(orderService.create(token,orderItem), orderItem);
    }

    @GetMapping("/api/orders/my-orders")
    public ResponseEntity<?> getOrders(@RequestHeader("Authorization") String token){
        return ResponseEntity.ok(orderService.getMyOrders(token));
    }

    @GetMapping("/api/orders/status/{status}")
    public ResponseEntity<?> getOrderByStatus(@PathVariable String status){
        return ResponseEntity.ok(orderService.findOrderByStatus(status));
    }

    @PutMapping("/api/orders/status/{orderId}")
    public ResponseEntity<?> updateOrderStatusById(@PathVariable long orderId){
        return ResponseEntity.ok(orderService.updateOrderStatusByOrderId(orderId));
    }


}
