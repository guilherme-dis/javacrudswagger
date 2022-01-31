package com.ufu.javacrudswagger.dto;

import com.ufu.javacrudswagger.entities.Address;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AddressDTO {
    private Long id;
    private String country;
    private String city;
    private String state;
    private String streat;
    private String number;
    private String complement;
    private String cep;

    public AddressDTO() {
    }

    public AddressDTO(Long id, String country, String city, String state, String streat, String number, String complement, String cep) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.state = state;
        this.streat = streat;
        this.number = number;
        this.complement = complement;
        this.cep = cep;
    }
    public Address transformaParaObjeto(){
        return new Address(id,country,city,state,streat,number,complement,cep);
    }
}
