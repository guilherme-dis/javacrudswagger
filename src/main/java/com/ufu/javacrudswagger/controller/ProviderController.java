package com.ufu.javacrudswagger.controller;

import com.ufu.javacrudswagger.entities.Provider;
import com.ufu.javacrudswagger.services.ProviderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PostMapping
    @ApiOperation(value = "saving a provider")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to save this"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    public Provider insert(@RequestBody @Valid Provider provider) {
        return providerService.save(provider);
    }

    @GetMapping
    @ApiOperation(value = "return a provider list")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to find all providers"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    public ResponseEntity<Page<Provider>> findAll(Pageable pageable) {
        return ResponseEntity.ok(providerService.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "selecting an provider by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to find this"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    public ResponseEntity<Provider> getById(@PathVariable Long id) {
        return providerService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete a Provider")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "deleting successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to delete this"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 420, message = "the data you tried to delete has other data related to it as a foreign key")})
    public ResponseEntity<Provider> Delete(@PathVariable Long id) {
        return providerService.deleteById(id);
    }


}
