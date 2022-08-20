package com.example.persistant.service;

import com.example.persistant.entity.Person;
import com.example.persistant.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public List<Person> getAllByLastName(String lastName) {
        return personRepository.findAllByLastName(lastName).orElseThrow(NoSuchElementException::new);
    }

    public List<Person> getAllByFirstName(String firstName) {
        return personRepository.findAllPersonsByFirstName(firstName).orElseThrow(NoSuchElementException::new);
    }
}
