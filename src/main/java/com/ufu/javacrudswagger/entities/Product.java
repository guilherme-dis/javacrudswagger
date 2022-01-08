package com.ufu.javacrudswagger.entities;

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
    private Long id;
    @Column(length = 50)
    @NotEmpty(message = "The Product name cannot be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotEmpty(message = "The Price cannot be empty")
    @Min(0)
    private Double price;

    @NotEmpty(message = "The Qtd_store cannot be empty")
    @Min(0)
    private Integer qtd_store;


    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

}
