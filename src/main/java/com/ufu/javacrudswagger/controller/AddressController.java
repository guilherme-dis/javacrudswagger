package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Address;
import com.ufu.javacrudswagger.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;


    @GetMapping
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @GetMapping("/{id}")
    public Address findbyid(@PathVariable Long id){return addressRepository.findById(id).get();}

    @PostMapping
    public Address insert(@RequestBody Address address) {
        return addressRepository.save(address);
    }

    @DeleteMapping("/{id}")
    public void deleteCarro(@PathVariable Long id){
        addressRepository.deleteById(id);
    }




//todo estudar esse responseentity
//    public ResponseEntity<Page<Address>> findAll(Pageable pageable){
//        Page<Address>result= addressRepository.findAll(pageable);
//        return ResponseEntity.ok(result);
//    }
}
