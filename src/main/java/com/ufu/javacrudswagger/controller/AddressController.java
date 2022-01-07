package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Address;
import com.ufu.javacrudswagger.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressRepository addressRepository;

    @PostMapping
    public Address insert(@RequestBody @Valid Address address) {
        return addressRepository.save(address);
    }
    //verificar os dados, se não vai dar erro no banco


    @GetMapping
    public ResponseEntity<Page<Address>> findAll(Pageable pageable){
        Page<Address>result= addressRepository.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable Long id){
        Optional<Address> addressOptional = addressRepository.findById(id);
        return addressOptional.map(address -> new ResponseEntity<>(address, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        /*
        if(addressOptional.isPresent())
            return new ResponseEntity<Address>(addressOptional.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         */
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> Delete(@PathVariable Long id)
    {
        try {
            addressRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            Optional<Address> address=addressRepository.findById(id);
            if (address.isPresent()){
                return new ResponseEntity<>(HttpStatus.valueOf(420));
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }
}
