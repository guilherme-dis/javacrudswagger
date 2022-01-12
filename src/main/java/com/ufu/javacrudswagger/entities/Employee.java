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
    //Swagger
    @ApiModelProperty(notes="Is the id of the employee")
    private Long id;

    //Entity
    @Column(length = 50)
    //Validation
    @NotEmpty(message = "The Employee name cannot be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    //Swagger
    @ApiModelProperty(notes="Is the name of the employee")
    private String name;

    //Entity
    @Column(length = 50)
    //Validationi
    @NotEmpty(message = "The Employee occupation cannot be empty")
    @Size(min = 3, max = 50, message = "Occupation must be between 3 and 50 characters")
    //Swagger
    @ApiModelProperty(notes="Is the ocupation of the employee")
    private String occupation;

    //Entity
    @Column(length = 50)
    //Validation
    @NotEmpty(message = "The Employee username cannot be empty")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    //Swagger
    @ApiModelProperty(notes="Is the username of the employee")
    private String username;

    //Entity
    @Column(length = 50)
    //Validation
    @NotEmpty(message = "The Employee password cannot be empty")
    @Size(min = 3, max = 50, message = "Password must be between 3 and 50 characters")
    //Swagger
    @ApiModelProperty(notes="Is the password of the employee")
    private String password;

    //Entity
    @ManyToOne
    @JoinColumn(name = "address_id")
    //Swagger
    @ApiModelProperty(notes="Is the address class of the employee")
    private Address address;

}
