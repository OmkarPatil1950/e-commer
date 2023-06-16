package com.emart.repository;

import com.emart.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

//    @Query("SELECT o.order_Date, o.order_Total, c.quantity, c.total_Cost, c.customer.customer_Id, c.product.product_Id " +
//            "FROM Orders o " +
//            "JOIN o.cart c " +
//            "WHERE c.customer.customer_Id = :customer_Id")
//    List<Object[]> getOrdersByCustomerId(@Param("customer_Id") int customer_Id);

	@Query(value = "SELECT o.order_date AS OrderDate, " +
            "o.order_total AS OrderTotal, " +
            "c.quantity AS quantity, " +
            "c.total_cost AS totalCost, " +
            "c.customer_id AS customerId " +
            "FROM Orders o " +
            "JOIN cart c ON c.id = o.cart_id_fk " +
            "WHERE c.customer_id = :customer_Id", nativeQuery = true)
List<Object[]> getOrdersByCustomerId(@Param("customer_Id") int customer_Id);

}
