package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Address;
import com.ufu.javacrudswagger.entities.Bonus;
import com.ufu.javacrudswagger.repositories.BonusRepotitory;
import com.ufu.javacrudswagger.services.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bonus")
public class BonusController {
    @Autowired
    private BonusService bonusService;

    @PostMapping
    public Bonus insert(@RequestBody  Bonus bonus){
        return bonusService.insert(bonus);
    }

    @GetMapping
    public ResponseEntity<Page<Bonus>> findAll(Pageable pageable){
        Page<Bonus>result= bonusService.findAll(pageable);
        return ResponseEntity.ok(result);
    }

}
