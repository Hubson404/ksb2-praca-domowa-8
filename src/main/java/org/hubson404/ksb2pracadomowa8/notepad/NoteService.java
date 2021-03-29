package org.hubson404.ksb2pracadomowa8.notepad;

import lombok.RequiredArgsConstructor;
import org.hubson404.ksb2pracadomowa8.exceptions.NoteNotFoundException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public NotesWrapper findAllNotes() {
        List<Note> allNotes = noteRepository.findAll();
        return wrapNotesList(allNotes);
    }

    public NoteDto findNoteById(Long id) {
        Note note = getNoteFromRepository(id);
        return noteMapper.mapToNoteDto(note);
    }

    public NoteDto createNote(NoteDto noteDto){
        Note savedNote = noteRepository.save(noteMapper.mapToNote(noteDto));
        return noteMapper.mapToNoteDto(savedNote);
    }

    public NoteDto modifyNote(NoteDto noteDto){
        Note note = getNoteFromRepository(noteDto.getId());
        note.setTitle(noteDto.getTitle());
        note.setContent(noteDto.getContent());
        Note savedNote = noteRepository.save(note);
        return noteMapper.mapToNoteDto(savedNote);
    }

    private Note getNoteFromRepository(Long id) {
        Optional<Note> noteById = noteRepository.findById(id);
        return noteById.orElseThrow(() -> new NoteNotFoundException(id));
    }

    private NotesWrapper wrapNotesList(List<Note> notesList) {
        List<NoteDto> mappedList = notesList.stream()
                .map(noteMapper::mapToNoteDto)
                .collect(Collectors.toList());
        return new NotesWrapper(mappedList);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void insertDataToDb() {
        Note note1 = new Note();
        note1.setTitle("Test note title");
        note1.setContent("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has " +
                "been the industry's standard dummy text ever since the 1500s.  Lorem Ipsum has been the industry's " +
                "standard dummy text ever since the 1500s.");
        Note note2 = new Note();
        note2.setTitle("Another note title");
        note2.setContent("It is a long established fact that a reader will be distracted by the readable content " +
                "of a page when looking at its layout.It is a long established fact that a reader will be distracted " +
                "by the readable content of a page when looking at its layout.");

        noteRepository.save(note1);
        noteRepository.save(note2);
    }

}
