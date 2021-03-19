package kz.aitu.project.repository;

import kz.aitu.project.entity.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAll();


    List<Order> findById(long orderId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO orders(customer_id, order_date, total_price, status) VALUES(:customer_id, :order_date, :total_price, :status)", nativeQuery = true)
    void insertOrder(@Param("customer_id") long customer_id,@Param("order_date") LocalDate order_date, @Param("total_price") long total_price, @Param("status") String status);

    @Query(value = "SELECT * FROM orders WHERE status = :status", nativeQuery = true)
    List<Order> findOrderByStatus(String status);

    List<Order> findAllByCustomerId(long id);
}
