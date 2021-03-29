package org.hubson404.ksb2pracadomowa8.notepad;

import org.springframework.stereotype.Component;

@Component
public class NoteMapper {

    public NoteDto mapToNoteDto(Note note) {
        return new NoteDto(
                note.getId(),
                note.getTitle(),
                note.getContent());
    }

    public Note mapToNote(NoteDto noteDto) {
        Note note = new Note();
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        return note;
    }

}
