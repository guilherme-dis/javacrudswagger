package com.ufu.javacrudswagger.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Swagger
    @ApiModelProperty(notes="Is the id of the address")
    private Long id;

    //Entity
    @Column(length = 50)
    //Validation
    @NotEmpty(message = "The address country cannot be empty")
    @Size(min = 3, max = 50, message = "Country must be between 3 and 50 characters")
    //Swagger
    @ApiModelProperty(notes ="Is the country of the address")
    private String country;

    //Entity
    @Column(length = 50)
    //Validation
    @NotEmpty(message = "The address city cannot be empty")
    @Size(min = 3, max = 50, message = "City must be between 3 and 50 characters")
    //Swagger
    @ApiModelProperty(notes="Is the city of the address")
    private String city;

    //Entity
    @Column(length = 2)
    //Validation
    @NotEmpty(message = "The address state cannot be empty")
    @Size(min = 2, max = 2, message = "State must be 2 characters")
    //Swagger
    @ApiModelProperty(notes="Is the state of the address")
    private String state;

    //Entity
    @Column(length = 50)
    //Validation
    @NotEmpty(message = "The address streat cannot be empty")
    @Size(min = 3, max = 50, message = "Streat must be between 3 and 50 characters")
    //Swagger
    @ApiModelProperty(notes="Is the streat of the address")
    private String streat;

    //Entity
    @Column(length = 7)
    //Validation
    @NotEmpty(message = "The address number cannot be empty")
    @Size(min = 1, max = 7, message = "Number must be between 1 and 7 characters")
    //Swagger
    @ApiModelProperty(notes="Is the number of the address")
    private String number;

    //Entity
    @Column(length = 50)
    //Validation
    @NotEmpty(message = "The address complement cannot be empty")
    @Size(min = 3, max = 50, message = "Complement must be between 3 and 50 characters")
    //Swagger
    @ApiModelProperty(notes="Is the complement of the address")
    private String complement;

    //Entity
    @Column(length = 8)
    //Validation
    @NotEmpty(message = "The address cep cannot be empty")
    @Size(min = 8, max = 8, message = "Cep must be 8 characters")
    //Swagger
    @ApiModelProperty(notes="Is the cep of the address")
    private String cep;

}