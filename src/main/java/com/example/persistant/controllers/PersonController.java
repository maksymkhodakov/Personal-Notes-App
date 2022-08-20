package com.example.persistant.controllers;

import com.example.persistant.entity.Person;
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

    @GetMapping("/findByLastName/{lastName}")
    public List<Person> getByLastName(@PathVariable("lastName") String lastName) {
        return personService.getAllByLastName(lastName);
    }

    @GetMapping("/findByFirstName/{firstName}")
    public List<Person> getByFirstName(@PathVariable("firstName") String firstName) {
        return personService.getAllByFirstName(firstName);
    }
}
