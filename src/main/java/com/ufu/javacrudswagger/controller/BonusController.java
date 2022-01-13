package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Bonus;
import com.ufu.javacrudswagger.services.BonusService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bonus")
public class BonusController {
    @Autowired
    private BonusService bonusService;

    @PostMapping
    @ApiOperation(value = "saving a bonus")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to save this bonus"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    public Bonus insert(@RequestBody  Bonus bonus){
        return bonusService.insert(bonus);
    }

    @GetMapping
    @ApiOperation(value = "return a bonus list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to find all bonus"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    public ResponseEntity<Page<Bonus>> findAll(Pageable pageable){
        Page<Bonus>result= bonusService.findAll(pageable);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "selecting an bonus by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to find this"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    public ResponseEntity<Bonus> getById(@PathVariable Long id) {
        return bonusService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a bonus")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "deleting successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to delete this"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 420, message = "the data you tried to delete has other data related to it as a foreign key")})
    public ResponseEntity<Bonus> Delete(@PathVariable Long id) {
        return bonusService.deleteById(id);
    }

}
