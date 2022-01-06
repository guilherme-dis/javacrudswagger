package com.ufu.javacrudswagger.repositories;

import com.ufu.javacrudswagger.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
