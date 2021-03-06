package com.ufu.javacrudswagger.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_bonus")
public class Bonus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
    private Long id;

//    @Column(length = 11)
//    @NotEmpty(message = "The CPF cannot be empty")
//    @Size(min = 11, max = 11, message = "CPF must be between 8 characters")
    private String cpf;

//    @NotEmpty(message = "The score cannot be empty")
//    @Min(0)
    private Double score;

//    @NotEmpty(message = "The cash_back cannot be empty")
//    @Min(0)
    private Double cash_back;

}
