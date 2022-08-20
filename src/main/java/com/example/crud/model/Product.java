package com.example.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor @Getter
@Setter @AllArgsConstructor
@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private double finalPrice;
    private LocalDateTime endTime;
    @OneToOne
    private User winner;
    private String description;
    @OneToMany
    private List<Bid> bid;
    @OneToOne
    private Type type;
}
