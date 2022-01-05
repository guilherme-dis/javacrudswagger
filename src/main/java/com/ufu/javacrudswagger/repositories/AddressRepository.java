package com.ufu.javacrudswagger.repositories;

import com.ufu.javacrudswagger.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {

}
