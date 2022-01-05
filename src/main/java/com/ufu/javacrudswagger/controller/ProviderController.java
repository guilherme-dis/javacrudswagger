package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Provider;
import com.ufu.javacrudswagger.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/provider")
public class ProviderController {

    @Autowired
    private ProviderRepository providerRepository;

    @PostMapping
    public Provider insert(@RequestBody Provider provider){
        return providerRepository.save(provider);
    }

}
