package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Address;
import com.ufu.javacrudswagger.entities.Product;
import com.ufu.javacrudswagger.repositories.AddressRepository;
import com.ufu.javacrudswagger.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    public Product insert(@RequestBody Product product) {
        return productRepository.save(product);
    }
    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable){
        Page<Product>result= productRepository.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id){
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.map(product -> new ResponseEntity<>(product, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> Delete(@PathVariable Long id)
    {
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            Optional<Product> product=productRepository.findById(id);
            if (product.isPresent()){
                return new ResponseEntity<>(HttpStatus.valueOf(420));
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }
}
