package com.ufu.javacrudswagger.entities;

import lombok.*;

import javax.persistence.*;

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
    private String name;
    private Double price;
    private Integer qtd_store;


    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

}
