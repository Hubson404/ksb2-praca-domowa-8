package org.hubson404.ksb2pracadomowa8.exceptions;

public class NoteNotFoundException extends RuntimeException{
    public NoteNotFoundException(Long id) {
        super("Could not find note with id: " + id);
    }
}
