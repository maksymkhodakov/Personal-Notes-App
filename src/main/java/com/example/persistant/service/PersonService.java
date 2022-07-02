package com.example.persistant.service;

import com.example.persistant.entity.Person;
import com.example.persistant.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public void save(Person person) {
        personRepository.save(person);
    }
}
