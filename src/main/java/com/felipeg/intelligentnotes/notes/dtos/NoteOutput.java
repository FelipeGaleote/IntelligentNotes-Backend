package com.felipeg.intelligentnotes.notes.dtos;

import com.felipeg.intelligentnotes.notes.models.Note;
import org.springframework.data.domain.Page;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;

public class NoteOutput {

    private Long id;
    private String title;
    private String content;
    private String creationDate;

    private NoteOutput(Long id, String title, String content, String creationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    private NoteOutput() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public static NoteOutput fromNote(Note note) {
        String formattedDate = ISO_OFFSET_DATE_TIME.format(note.getCreationDate());
        return new NoteOutput(note.getId(), note.getTitle(), note.getContent(), formattedDate);
    }

    public static Page<NoteOutput> fromNotes(Page<Note> notes) {
        return notes.map(NoteOutput::fromNote);
    }
}
