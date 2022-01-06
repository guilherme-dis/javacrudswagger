package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Product;
import com.ufu.javacrudswagger.entities.Provider;
import com.ufu.javacrudswagger.repositories.ProductRepository;
import com.ufu.javacrudswagger.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

    @Autowired
    private ProviderRepository providerRepository;

    @PostMapping
    public Provider insert(@RequestBody Provider provider){
        return providerRepository.save(provider);
    }


    @GetMapping
    public ResponseEntity<Page<Provider>> findAll(Pageable pageable){
        Page<Provider>result= providerRepository.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provider> getById(@PathVariable Long id){
        Optional<Provider> providerOptional = providerRepository.findById(id);
        return providerOptional.map(provider -> new ResponseEntity<>(provider, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> Delete(@PathVariable Long id)
    {
        Optional<Provider> provider = providerRepository.findById(id);

        if(provider.isPresent()){
            providerRepository.delete(provider.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
