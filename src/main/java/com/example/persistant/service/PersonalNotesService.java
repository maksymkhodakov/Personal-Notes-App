package com.example.persistant.service;

import com.example.persistant.entity.Note;
import com.example.persistant.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonalNotesService {
    private final PersonRepository personalRepository;

    @Transactional
    public void addNote(Long personId, Note note) {
        var person = personalRepository.findById(personId)
                .orElseThrow();
        person.addNote(note);
    }
}
