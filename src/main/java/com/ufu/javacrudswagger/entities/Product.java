package com.ufu.javacrudswagger.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Swagger
    @ApiModelProperty(notes="Is the id of the product")
    private Long id;

    //Entity
    @Column(length = 50)
    //Validation
    @NotEmpty(message = "The Product name cannot be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    //Validation
    @NotEmpty(message = "The Price cannot be empty")
    @Min(0)
    //Swagger
    @ApiModelProperty(notes="Is the price of the product")
    private Double price;

    //Validation
    @NotEmpty(message = "The Qtd_store cannot be empty")
    @Min(0)
    //Swagger
    @ApiModelProperty(notes="how many products do you have in stock")
    private Integer qtd_store;

    //Entity
    @ManyToOne
    @JoinColumn(name = "provider_id")
    //Swagger
    @ApiModelProperty(notes="Is the provider class of the product")
    private Provider provider;

}
