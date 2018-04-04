package edu.edgetech.database;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByLastName(String lastName); // ties to databaseApplication line 39
}
