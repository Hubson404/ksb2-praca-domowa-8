package org.hubson404.ksb2pracadomowa8.notepad;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/api/notes")
    public NotesWrapper findAllNotes(){
        return noteService.findAllNotes();
    }

    @GetMapping("/api/notes/{id}")
    public NoteDto findNoteById(@PathVariable Long id){
        return noteService.findNoteById(id);
    }

    @PostMapping("/api/notes")
    @ResponseStatus(HttpStatus.CREATED)
    public NoteDto createNote(@RequestBody NoteDto noteDto) {
        return noteService.createNote(noteDto);
    }

    @PatchMapping("/api/notes")
    @ResponseStatus(HttpStatus.CREATED)
    public NoteDto modifyNote(@RequestBody NoteDto noteDto) {
        return noteService.modifyNote(noteDto);
    }
}
