package com.turvo.assesment.shipmenttracking.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turvo.assesment.shipmenttracking.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Serializable> {

}
