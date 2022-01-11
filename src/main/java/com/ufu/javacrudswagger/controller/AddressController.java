package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Address;
import com.ufu.javacrudswagger.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public Address insert(@RequestBody @Valid Address address) {
        return addressService.save(address);
    }

    @GetMapping
    public ResponseEntity<Page<Address>> findAll(Pageable pageable) {
        return ResponseEntity.ok(addressService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable Long id) {
        return addressService.findById(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Address> Delete(@PathVariable Long id) {
        return addressService.deleteById(id);
    }

}
