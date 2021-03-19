package kz.aitu.project.service;


import kz.aitu.project.entity.Authorization;
import kz.aitu.project.entity.Order;
import kz.aitu.project.entity.OrderItem;
import kz.aitu.project.repository.AuthorizationRepository;
import kz.aitu.project.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;
    private AuthorizationRepository authorizationRepository;

    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    public List<Order> getById(long orderId) {
        return orderRepository.findById(orderId);
    }

    public Optional<Order> findOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public int getEventualPrice(List<OrderItem> orderItemList){
        int entirePrice = 0, counter = 0;
        while(counter< orderItemList.size()){
            entirePrice = entirePrice + (orderItemList.get(counter).getPrice()*orderItemList.get(counter).getQuantity());
            counter++;
        }
        return entirePrice;
    }

    public List<Order> getMyOrders(String token) {
        Authorization authorization = authorizationRepository.findByToken(token);
        List<Order> myOrder = new ArrayList<Order>();
        for(Order order: orderRepository.findAll() ){
            if (order.getCustomerId() == authorization.getCustomerId()){
                myOrder.add(order);
            }
        }
        return myOrder;
    }

    public long create(String token, List<OrderItem> orderItemList)  {
        Authorization authorization = authorizationRepository.findByToken(token);
        String orderStatus = "received";
        LocalDate orderDate = LocalDate.now();
        long totalPrice = getEventualPrice(orderItemList);
        orderRepository.insertOrder(authorization.getCustomerId(), orderDate, totalPrice, orderStatus);
        List<Order> orderList = orderRepository.findAll();
        return orderList.get(orderList.size()-1).getOrderId();
    }

    public List<Order> findOrderByStatus(String status) {
        return orderRepository.findOrderByStatus(status);
    }

    public Order updateOrderStatusByOrderId(Long orderId) {
        Optional<Order> orderRequest = orderRepository.findById(orderId);
        Order orderStatus = orderRequest.get();
        if(orderStatus.equals("received")){
            orderStatus.setStatus("in process");
        }else{
            orderStatus.setStatus("finished");
        }
        return orderRepository.save(orderStatus);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
