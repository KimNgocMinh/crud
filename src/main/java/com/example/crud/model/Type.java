package com.example.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity @NoArgsConstructor
@AllArgsConstructor @Getter @Setter
public class Type {

    @Id
    private String name;
    @ManyToOne
    private Type parentType;

}
