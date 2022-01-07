package com.ufu.javacrudswagger.entities;

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
    private Long id;
    @Column(length = 50)
    @NotEmpty(message = "The address country cannot be empty")
    @Size(min = 3, max = 50, message = "Country must be between 3 and 50 characters")
    private String country;

    @Column(length = 50)
    @NotEmpty(message = "The address city cannot be empty")
    @Size(min = 3, max = 50, message = "City must be between 3 and 50 characters")
    private String city;

    @Column(length = 2)
    @NotEmpty(message = "The address state cannot be empty")
    @Size(min = 2, max = 2, message = "State must be 2 characters")
    private String state;

    @Column(length = 50)
    @NotEmpty(message = "The address streat cannot be empty")
    @Size(min = 3, max = 50, message = "Streat must be between 3 and 50 characters")
    private String streat;

    @Column(length = 7)
    @NotEmpty(message = "The address number cannot be empty")
    @Size(min = 1, max = 7, message = "Number must be between 1 and 7 characters")
    private String number;

    @Column(length = 50)
    @NotEmpty(message = "The address complement cannot be empty")
    @Size(min = 3, max = 50, message = "Complement must be between 3 and 50 characters")
    private String complement;

    @Column(length = 8)
    @NotEmpty(message = "The address cep cannot be empty")
    @Size(min = 8, max = 8, message = "Cep must be 8 characters")
    private String cep;

}