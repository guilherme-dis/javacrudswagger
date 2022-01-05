package com.ufu.javacrudswagger.repositories;

import com.ufu.javacrudswagger.entities.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider,Long> {
}
