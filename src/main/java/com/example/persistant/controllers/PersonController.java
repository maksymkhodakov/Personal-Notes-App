package com.example.persistant.controllers;

import com.example.persistant.entity.Person;
import com.example.persistant.repository.PersonRepository;
import com.example.persistant.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping()
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        personService.save(person);
        var location = fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(person.getId())
                .toUri();
        return ResponseEntity.created(location)
                .body(person);
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }
}
