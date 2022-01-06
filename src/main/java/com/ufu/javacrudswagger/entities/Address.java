package com.ufu.javacrudswagger.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;


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
    private Long id;
    @Column(length = 50)
    private String country;
    @Column(length = 50)
    private String city;
    @Column(length = 2)
    private String state;
    @Column(length = 50)
    private String streat;
    @Column(length = 7)
    private String number;
    @Column(length = 50)
    private String complement;
    @Column(length = 8)
    private String cep;


}