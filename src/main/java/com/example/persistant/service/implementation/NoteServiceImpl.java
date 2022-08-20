package com.example.persistant.service.implementation;

import com.example.persistant.dto.NoteDto;
import com.example.persistant.repository.NoteRepository;
import com.example.persistant.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public List<NoteDto> getAllNotes() {
        return noteRepository.findAll()
                .stream()
                .map(note -> new NoteDto(note.getBody(), note.getPerson().getFirstName(), note.getPerson().getLastName()))
                .toList();
    }

    @Override
    public List<NoteDto> getAllByBodyStart(String bodyStart) {
        try (var notesStream = noteRepository.findAllByBodyStartsWith(bodyStart)) {
            return notesStream
                    .map(n -> new NoteDto(n.getBody(), n.getPerson().getFirstName(), n.getPerson().getLastName()))
                    .toList();
        }
    }
}
