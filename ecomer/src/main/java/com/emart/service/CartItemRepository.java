package com.emart.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
@Transactional
public interface CartItemRepository extends JpaRepository<cartitem, Integer> {

//    @Modifying
//    @Query(value = "UPDATE cartitem SET quantity = :quantity WHERE cart_Item_Id = :id", nativeQuery = true)
//    void updateQuantity(@Param("quantity") int quantity, @Param("id") int id);

}
