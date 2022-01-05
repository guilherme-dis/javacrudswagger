package com.ufu.javacrudswagger.entities;

import lombok.*;

import javax.persistence.*;


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

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", streat='" + streat + '\'' +
                ", number='" + number + '\'' +
                ", complement='" + complement + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreat() {
        return streat;
    }

    public void setStreat(String streat) {
        this.streat = streat;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Address() {
    }

    public Address(Long id, String country, String city, String state, String streat, String number, String complement, String cep) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.state = state;
        this.streat = streat;
        this.number = number;
        this.complement = complement;
        this.cep = cep;
    }
}