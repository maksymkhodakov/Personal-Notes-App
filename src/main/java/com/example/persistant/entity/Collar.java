package com.example.persistant.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "collar")
public class Collar {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "id")
    @OneToOne
    private Pet pet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Collar collar = (Collar) o;
        return id != null && Objects.equals(id, collar.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}