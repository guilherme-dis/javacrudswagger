package com.ufu.javacrudswagger.services;

import com.ufu.javacrudswagger.entities.Address;
import com.ufu.javacrudswagger.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Page<Address> findAll(Pageable pageable){
        return addressRepository.findAll(pageable);
    }

    public Address save(Address address){
        return addressRepository.save(address);
    }

    public ResponseEntity<Address> findById(Long id){
        Optional<Address> addressOptional = addressRepository.findById(id);
        return addressOptional.map(address -> new ResponseEntity<>(address, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

//        if(addressOptional.isPresent())
//            return new ResponseEntity<Address>(addressOptional.get(), HttpStatus.OK);
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Address> deleteById(Long id){
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
