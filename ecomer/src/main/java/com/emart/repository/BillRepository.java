package com.emart.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.emart.entities.Cart;
@Transactional
public interface BillRepository extends JpaRepository<Cart, Integer> {

	@Query(value = "SELECT p.p_Id AS productId, " +
	        "p.p_Image AS productImage, " +
	        "p.p_name AS productName, " +
	        "p.p_price AS productPrice, " +
	        "cu.first_name AS firstName, " +
	        "cu.last_name AS lastName, " +
	        "c.quantity AS quantity, " +
	        "c.total_cost AS totalCost, " +
	        "c.id AS cid, " +
	        "pd.p_description AS productDescription " +
	        "FROM cart c " +
	        "JOIN product p ON c.p_id = p.p_id " +
	        "JOIN customer cu ON c.customer_id = cu.customer_id " +
	        "JOIN productdetails pd ON p.p_id = pd.p_id " +
	        "LEFT JOIN orders o ON c.id = o.cart_id_fk " +
	        "WHERE cu.email_id = :email_id " +
	        "AND o.cart_id_fk IS NULL", nativeQuery = true)
	List<Object[]> getBill(@Param("email_id") String email_id);

//List<Object[]> getBill(@Param("email_id") String email_id);


//    @Query(value = "SELECT p.p_Id AS productId, " +
//            "p.p_Image AS productImage, " +
//            "p.p_name AS productName, " +
//            "p.p_price AS productPrice, " +
//            "cu.first_name AS firstName, " +
//            "cu.last_name AS lastName, " +
//            "c.quantity AS quantity, " +
//            "c.total_cost AS totalCost, " +
//            "c.id AS cid, " +
//            "pd.p_description AS productDescription " +
//            "FROM cart c " +
//             "JOIN product p ON c.p_id = p.p_id " +
//            "JOIN customer cu ON c.customer_id = cu.customer_id " +
//            "JOIN productdetails pd ON p.p_id = pd.p_id " +
//            "WHERE cu.email_id = :email_id " +
//            ")", nativeQuery = true)
//    List<Object[]> getBill(@Param("email_id") String email_id);
}

 
