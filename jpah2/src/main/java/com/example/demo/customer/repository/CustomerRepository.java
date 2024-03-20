package com.example.demo.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.customer.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{ //interface끼리 상속은 extends

	List<Customer> findByNameLike(String name);
}
