package com.example.persistant.repository;

import com.example.persistant.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface NoteRepository extends JpaRepository<Note, Long> {
    <T> Page<T> findAllBy(Class<T> type, Pageable pageable);

    @Query("from Note n left join fetch n.person")
    Stream<Note> findAllByBodyStartsWith(String bodyStart);
}
