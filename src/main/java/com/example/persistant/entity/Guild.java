package com.example.persistant.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Guild {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "guilds", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ToString.Exclude
    private List<Employee> employees = new ArrayList<>();

    public Guild(String name) {
        this.name = name;
    }

    public void addEmployee(Employee employee) {
        employee.getGuilds().add(this);
        employees.add(employee);
    }
}
