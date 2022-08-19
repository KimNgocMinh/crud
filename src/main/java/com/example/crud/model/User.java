package com.example.crud.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    @OneToMany
    private List<Product> boughtProduct;
    private double balance;
    @OneToMany
    private List<Address> address;
    private String email;
    @OneToMany
    private List<Bid> bid;
}
