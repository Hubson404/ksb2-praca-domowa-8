package org.hubson404.ksb2pracadomowa8.notepad;

import lombok.RequiredArgsConstructor;
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


}
