package kz.aitu.project.repository;


import kz.aitu.project.entity.OrderItem;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {

    List<OrderItem> findAll();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO order_item(product_id, product_name, quantity, price, order_id) VALUES (:product_id, :product_name, :quantity, :price, :order_id)", nativeQuery = true)
    void createOrderItem(@Param("product_id") long product_id, @Param("product_name") String product_name, @Param("quantity") int quantity, @Param("price") long price, @Param("order_id") long order_id);

    List<OrderItem> findAllByOrderId(long orderId);
}
