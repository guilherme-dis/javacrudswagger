package com.ufu.javacrudswagger.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String occupation;
    @Column(length = 50)
    private String username;
    @Column(length = 50)
    private String password;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
