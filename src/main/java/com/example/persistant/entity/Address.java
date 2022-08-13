package com.example.persistant.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@ToString(exclude = "user")
public class Address {
    @Id
    @GeneratedValue
    private Long id;

    private String city;

    private String street;

    private String number;

    private String apt;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Address() {
    }
}
