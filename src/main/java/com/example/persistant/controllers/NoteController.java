package com.example.persistant.controllers;

import com.example.persistant.dto.NoteDto;
import com.example.persistant.entity.Person;
import com.example.persistant.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public List<NoteDto> getAll(){
        return noteService.getAllNotes();
    }

    @GetMapping("/findByBodyStart")
    public List<NoteDto> getAllByBodyStart(@RequestParam String bodyStart) {
        return noteService.getAllByBodyStart(bodyStart);
    }
}
