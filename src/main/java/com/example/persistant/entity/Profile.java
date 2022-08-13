package com.example.persistant.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@ToString
public class Profile {
    @Id
    private Long id;

    private boolean picture;

    private String photoUrl;

    @MapsId
    @OneToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;
}
