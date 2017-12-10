package com.epam.note.repos;

import com.epam.note.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {


    Note save(Note note);

    Note getById(int i);

    Note getNoteByTitle(String title);

}