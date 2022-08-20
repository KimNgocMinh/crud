package com.example.crud.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class User implements Serializable{
    @Id
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int trustPoint;
    @OneToMany
    private List<Product> soldProduct;
    @OneToMany
    private List<Product> boughtProduct;
    private double balance;
    @OneToMany
    private List<Address> address;
    private String email;
    @OneToMany
    private List<Bid> bid;
}
