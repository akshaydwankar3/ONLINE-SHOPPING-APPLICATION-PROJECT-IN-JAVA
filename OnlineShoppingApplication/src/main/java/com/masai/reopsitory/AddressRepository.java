package com.masai.reopsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
