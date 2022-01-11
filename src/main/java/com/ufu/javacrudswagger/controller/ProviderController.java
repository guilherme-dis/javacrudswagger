package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Address;
import com.ufu.javacrudswagger.entities.Provider;
import com.ufu.javacrudswagger.repositories.ProviderRepository;
import com.ufu.javacrudswagger.services.AddressService;
import com.ufu.javacrudswagger.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PostMapping
    public Provider insert(@RequestBody @Valid Provider provider) {
        return providerService.save(provider);
    }

    @GetMapping
    public ResponseEntity<Page<Provider>> findAll(Pageable pageable){
        return ResponseEntity.ok(providerService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provider> getById(@PathVariable Long id) {
        return providerService.findById(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Provider> Delete(@PathVariable Long id) {
        return providerService.deleteById(id);
    }


}
