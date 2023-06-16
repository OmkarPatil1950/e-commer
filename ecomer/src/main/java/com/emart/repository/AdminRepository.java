package com.emart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.emart.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

    /**
     * Find an admin by email.
     *
     * @param emailId The email of the admin to find.
     * @return The admin with the specified email.
     */
    public Admin findByemailId(@Param(value = "emailId") String emailId);
    
    Admin findByUsername(String username);
}
