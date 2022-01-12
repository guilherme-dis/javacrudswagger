package com.ufu.javacrudswagger.entities;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
    private Long id;
    @Column(length = 50)
    @NotEmpty(message = "The Employee name cannot be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Column(length = 50)
    @NotEmpty(message = "The Employee occupation cannot be empty")
    @Size(min = 3, max = 50, message = "Occupation must be between 3 and 50 characters")
    private String occupation;

    @Column(length = 50)
    @NotEmpty(message = "The Employee username cannot be empty")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @Column(length = 50)
    @NotEmpty(message = "The Employee password cannot be empty")
    @Size(min = 3, max = 50, message = "Password must be between 3 and 50 characters")
    private String password;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
