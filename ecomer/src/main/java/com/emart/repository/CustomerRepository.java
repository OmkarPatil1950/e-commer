package com.emart.repository;

import com.emart.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing Customer entities.
 */
@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	
	@Modifying
	 @Query("SELECT c FROM Customer c WHERE c.email_id = :email_id")
    List<Customer> findByEmail(@Param("email_id") String email_id);

	/**
     * Update the wallet balance of a customer.
     *
     * @param wallet       The new wallet balance.
     * @param customer_Id  The ID of the customer.
     */
    @Modifying
    @Query("update Customer c set c.wallet = :wallet where c.customer_Id = :customer_Id")
    void updateWallet(@Param("wallet") int wallet, @Param("customer_Id") int customer_Id);

    /**
     * Get a customer by their username.
     *
     * @param user  The username.
     * @return An optional containing the customer if found, or empty if not found.
     */
    @Query("from Customer c join Cart cr on c.customer_Id=cr.customer where username=:user")
    Optional<Object> getByUserName(@Param("user") String user);
    
    Customer findByUsername(String username);
}
