package com.example.persistant.repository;

import com.example.persistant.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);
    Person findByFirstNameAndLastName(String firstName, String lastName);
}
