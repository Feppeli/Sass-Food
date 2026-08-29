package com.Food.Food.Model;

import jakarta.persistence.*;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Atributos privados
    private String name;
    private String email;
    @Column(length = 255)
    private String password;
    private String cpf;

    protected UserModel() {}

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(unique=true)
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Constructor
    public UserModel(String cpf, String email, String name, String password) {
        this.cpf = cpf;
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
