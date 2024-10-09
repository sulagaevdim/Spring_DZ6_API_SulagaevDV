package ru.geekbrains.spring_dz6_api_sulagaevdv.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring_dz6_api_sulagaevdv.model.Note;
import ru.geekbrains.spring_dz6_api_sulagaevdv.repository.NoteRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {
    private NoteRepository noteRepository;

    /**
     * добавление заметки
     */
    public Note addNote(Note note){
        return noteRepository.save(note);
    }
    /**
     * Просмотр всех заметок
     */
    public List<Note> findAllNotes(){
        return noteRepository.findAll();
    }
    /**
     * Изменение заметки
     */
    public Note updateNote(Note newNote){
        Optional<Note> optionalNote = noteRepository.findById(newNote.getId());
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            note.setTitle(newNote.getTitle());
            note.setContent(newNote.getContent());
            note.setDate_create(LocalDate.now());
            return noteRepository.save(note);
        }else {
            throw new IllegalArgumentException("Note not found with ID: " + newNote.getId());
        }
    }
    /**
     * Удаление заметки
     */
    public void deleteNote(Long id){
        noteRepository.delete(noteRepository.getReferenceById(id));
    }
}
