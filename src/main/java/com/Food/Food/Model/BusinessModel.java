package com.Food.Food.Model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UniqueElements;

@Entity // Indica para o JPA/HIBERNATE/ que uma classe Java representa uma tabela relacional
public class BusinessModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public BusinessModel() {

    }

    //Atributos privados
    private String name;
    private String ownerId;
    private String email;
    private String cnpj;
    private String password;
    private Integer owener_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOwener_id() {
        return owener_id;
    }

    public void setOwener_id(Integer owener_id) {
        this.owener_id = owener_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BusinessModel(Long id, String name, String ownerId, String email, String cnpj, String password, Integer owener_id) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.email = email;
        this.cnpj = cnpj;
        this.password = password;
        this.owener_id = owener_id;
    }
}
