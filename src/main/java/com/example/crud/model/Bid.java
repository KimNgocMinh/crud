package com.example.crud.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter @Setter
@Entity @NoArgsConstructor
public class Bid implements Serializable {


    @Id
    private Long id;

    @MapsId
    @OneToOne
    private User user;

    @OneToOne
    private Product product;
    private String status;
    private LocalDateTime actionTime;
    private LocalDateTime scheduleTime;
    private double bidPrice;


}
