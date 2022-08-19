package com.example.crud.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@Entity @NoArgsConstructor
public class Bid implements Serializable {

    @OneToOne @Id
    private User user;
    @OneToOne
    private Product product;
    private LocalDateTime actionTime;
    private double bidPrice;



}
