package kz.aitu.project.controller;



import kz.aitu.project.service.OrderItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@AllArgsConstructor
public class OrderItemController {
    private OrderItemService orderItemService;

    @GetMapping("/api/order_items")
    public ResponseEntity<?> getAllOrderItems(){
        return ResponseEntity.ok(orderItemService.getAll());
    }

    @GetMapping("/api/orders_items/my-orders/{orderId}")
    public ResponseEntity<?> getMyOrders(@PathVariable long orderId){
        return ResponseEntity.ok(orderItemService.findAllById(orderId));
    }

}
