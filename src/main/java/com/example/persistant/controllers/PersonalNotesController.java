package com.example.persistant.controllers;

import com.example.persistant.entity.Note;
import com.example.persistant.service.PersonalNotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons/{personId}/notes")
@RequiredArgsConstructor
public class PersonalNotesController {
    private final PersonalNotesService personalNotesService;

    @PostMapping
    public void addNote(@PathVariable Long personId, @RequestBody Note note) {
        personalNotesService.addNote(personId, note);
    }
}
