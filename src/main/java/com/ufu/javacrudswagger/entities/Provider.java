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
@Table(name = "tb_provider")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Swagger
    @ApiModelProperty(notes="Is the id of the provider")
    private Long id;

    //Entity
    @Column(length = 50)
    //Validation
    @NotEmpty(message = "The Provider name cannot be empty")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    //Swagger
    @ApiModelProperty(notes="Is the name of the provider")
    private String name;

    //Entity
    @ManyToOne
    @JoinColumn(name = "address_id")
    //Swagger
    @ApiModelProperty(notes="Is the addres class of the provider")
    private Address address;

}
