package ru.geekbrains.spring_dz6_api_sulagaevdv.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring_dz6_api_sulagaevdv.model.Note;
import ru.geekbrains.spring_dz6_api_sulagaevdv.services.NoteService;
import java.util.List;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {
    private NoteService noteService;

    /**
     * для получения списка всех заметок нужно отправить Get запрос на адрес localhost:8080/notes
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        return new ResponseEntity<>(noteService.findAllNotes(), HttpStatus.OK);
    }
    /**
     * для добавления заметки нужно отправить POST запрос на адрес localhost:8080/notes
     */
    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.addNote(note), HttpStatus.OK);
    }
    /**
     * изменение заметки
     */
    @PutMapping
    public ResponseEntity<Note> updateNote(@RequestBody Note note){
        return new ResponseEntity<>(noteService.updateNote(note), HttpStatus.CREATED);
    }
    /**
     * удаление заметки по id
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
