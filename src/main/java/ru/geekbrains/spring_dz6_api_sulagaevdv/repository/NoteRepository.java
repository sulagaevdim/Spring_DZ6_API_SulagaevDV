package ru.geekbrains.spring_dz6_api_sulagaevdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring_dz6_api_sulagaevdv.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
