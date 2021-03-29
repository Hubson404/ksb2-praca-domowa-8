package org.hubson404.ksb2pracadomowa8.notepad;

import java.util.List;

public class NotesWrapper {

    private List<NoteDto> notes;

    public NotesWrapper() {
    }

    public NotesWrapper(List<NoteDto> notes) {
        this.notes = notes;
    }

    public List<NoteDto> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDto> notes) {
        this.notes = notes;
    }
}
