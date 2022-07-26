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
@Table(name = "pet")
public class Pet {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id")
    private Owner owner;

    @OneToOne(mappedBy = "pet")
    private Collar collar;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (getId() != null ? !getId().equals(pet.getId()) : pet.getId() != null) return false;
        if (getName() != null ? !getName().equals(pet.getName()) : pet.getName() != null) return false;
        if (getOwner() != null ? !getOwner().equals(pet.getOwner()) : pet.getOwner() != null) return false;
        return getCollar() != null ? getCollar().equals(pet.getCollar()) : pet.getCollar() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getOwner() != null ? getOwner().hashCode() : 0);
        result = 31 * result + (getCollar() != null ? getCollar().hashCode() : 0);
        return result;
    }
}