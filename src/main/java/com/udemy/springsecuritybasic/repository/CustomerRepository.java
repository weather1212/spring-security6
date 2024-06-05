package com.udemy.springsecuritybasic.repository;

import com.udemy.springsecuritybasic.model.Customer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

  List<Customer> findByEmail(String email);


}
