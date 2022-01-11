package com.ufu.javacrudswagger.services;

import com.ufu.javacrudswagger.entities.Provider;
import com.ufu.javacrudswagger.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    public Page<Provider> findAll(Pageable pageable){
        return providerRepository.findAll(pageable);
    }

    public Provider save(Provider provider){
        return providerRepository.save(provider);
    }

    public ResponseEntity<Provider> findById(Long id){
        Optional<Provider> providerOptional = providerRepository.findById(id);
        return providerOptional.map(provider -> new ResponseEntity<>(provider, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Provider> deleteById(Long id){
        try {
            providerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            Optional<Provider> provider=providerRepository.findById(id);
            if (provider.isPresent()){
                return new ResponseEntity<>(HttpStatus.valueOf(420));
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }
}
