package com.example.persistant.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "persons",
        uniqueConstraints = {
        @UniqueConstraint(name = "person_email_uq", columnNames = "email")}
)
public class Person {
    @Id
    @Column(
            name = "id",
            nullable = false,
            updatable = false
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(
            name = "email",
            unique = true,
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @JsonManagedReference
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Note> notes = new ArrayList<>();

    public void addNote(Note note) {
        note.setPerson(this);
        notes.add(note);
    }

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return id != null && Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
