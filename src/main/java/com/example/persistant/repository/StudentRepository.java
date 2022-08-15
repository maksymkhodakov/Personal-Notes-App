package com.example.persistant.repository;

import com.example.persistant.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("select (count(s) > 0) from Student s where s.id = ?1")
    boolean existsStudentsById(Long id);

    @Query("select (count(s) > 0) from Student s where s.email in :emails")
    boolean existsStudentsByEmailList(List<String> emails);

    @Query("select s from Student s where s.age = ?1")
    List<Optional<Student>> findStudentByAge(Integer age);
}
