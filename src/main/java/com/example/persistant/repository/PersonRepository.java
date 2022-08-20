package com.example.persistant.repository;

import com.example.persistant.dto.PersonDto;
import com.example.persistant.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);
    Person findByFirstNameAndLastName(String firstName, String lastName);
    Optional<List<Person>> findAllByLastName(String lastName);

    @Query("select distinct p from Person p left join fetch p.notes where p.firstName = :firstName")
    Optional<List<Person>> findAllPersonsByFirstName(String firstName);

    @Query("select new com.example.persistant.dto.PersonDto(p.firstName, p.lastName, n.size) from Person p left join p.notes n")
    List<PersonDto> findAllWithNotesCount();
}
