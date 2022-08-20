package com.example.persistant.service;

import com.example.persistant.dto.NoteDto;

import javax.transaction.Transactional;
import java.util.List;

public interface NoteService {
    @Transactional
    List<NoteDto> getAllNotes();

    @Transactional
    List<NoteDto> getAllByBodyStart(String bodyStart);
}
