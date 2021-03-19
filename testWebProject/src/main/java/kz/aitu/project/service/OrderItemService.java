package kz.aitu.project.service;


import kz.aitu.project.entity.OrderItem;
import kz.aitu.project.entity.Product;
import kz.aitu.project.repository.OrderItemRepository;
import kz.aitu.project.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;



@Service
@AllArgsConstructor
public class OrderItemService {
    private OrderItemRepository orderItemRepository;
    private ProductRepository productRepository;

    public List<OrderItem> getAll() {
        return orderItemRepository.findAll();
    }

    public void create(long orderId, List<OrderItem> orderItemArray){
        int counter = 0;
        while(counter < orderItemArray.size()){
            orderItemRepository.createOrderItem(orderItemArray.get(counter).getProductId(), orderItemArray.get(counter).getProductName(), orderItemArray.get(counter).getQuantity(),
                    orderItemArray.get(counter).getPrice(), orderId);
            counter++;
        }
    }

    public List<OrderItem> findAllById(long orderId) {
        return orderItemRepository.findAllByOrderId(orderId);
    }

}

