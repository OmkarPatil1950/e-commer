package com.emart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emart.entities.Category;
import com.emart.entities.Product;

/**
 * Repository interface for managing Product entities.
 */
@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Retrieve a list of products for a given category ID.
     *
     * @param category_Id The category ID.
     * @return A list of products.
     */
//    @Modifying
//    @Query("from Product p where p.cat_Id = :category_Id")
////    List<Product> getProducts(@Param("category_Id") int category_Id);
////
////    /**
////     * Retrieve a list of products matching a search keyword.
////     *
////     * @param search The search keyword.
////     * @return A list of products.
////     */
	@Modifying
	@Query("from Product  where cat_Id=:category_Id")
	List<Product> getProducts(@Param("category_Id")int category_Id );
	
	@Modifying
    @Query("from Product p where p.p_Name like %:search%")
    List<Product> getProductsBySearch(@Param("search") String search);

    /**
     * Retrieve a list of products with promotion.
     *
     * @return A list of products.
     */
    @Modifying
    @Query("from Product p where p.p_Promotion = true")
    List<Product> getProductsByPromotion();

    @Modifying
    @Query("update Product p set p.p_Name = :name, p.p_Price = :price, p.p_Image = :img where p.p_Id = :id")
    void update(@Param("name") String name, @Param("price") float price, @Param("img") String img, @Param("id") int id);

}
