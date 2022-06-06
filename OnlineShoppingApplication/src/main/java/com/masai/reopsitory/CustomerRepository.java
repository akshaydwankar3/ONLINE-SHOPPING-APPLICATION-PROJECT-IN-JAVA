package com.masai.reopsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Address;

@Repository
public interface CustomerRepository extends JpaRepository<Address, Integer>{

}
