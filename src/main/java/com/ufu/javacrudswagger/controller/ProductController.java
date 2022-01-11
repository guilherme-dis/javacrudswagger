package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Product;
import com.ufu.javacrudswagger.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product insert(@RequestBody @Valid Product product) {
        return productService.save(product);
    }

    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable) {
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return productService.findById(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Product> Delete(@PathVariable Long id) {
        return productService.deleteById(id);
    }

}
