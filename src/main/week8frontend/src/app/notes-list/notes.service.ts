import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {map} from "rxjs/operators";
import {Note} from "./note.model";
import {NotesResponseModel} from "./notes-response.model";

@Injectable({
  providedIn: 'root'
})
export class NotesService {

  notes: Note[] = [];

  constructor(private http: HttpClient) {
  }

  createNote(noteData: Note) {
    const newNote: Note = {
      title: noteData.title,
      content: noteData.content
    }
    return this.http
      .post(
        'http://localhost:8080/api/notes',
        newNote
      ).subscribe();
  }

  getNotes() {
    return this.http.get<NotesResponseModel>('http://localhost:8080/api/notes')
      .pipe(map((response) => {
          this.notes = response.notes;
          return this.notes;
        }
      ))
  }

  modifyNotes(modifiedNote: Note) {
    this.http.patch(
      'http://localhost:8080/api/notes',
      modifiedNote).subscribe();
  }
}
