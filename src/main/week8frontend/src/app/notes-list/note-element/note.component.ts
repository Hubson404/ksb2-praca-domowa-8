import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {Note} from "../note.model";
import {NotesService} from "../notes.service";

@Component({
  selector: 'app-note',
  templateUrl: './note.component.html',
  styleUrls: ['./note.component.css']
})
export class NoteComponent implements OnInit {

  @Input() note: Note;
  @ViewChild('noteForm') noteForm: NgForm;

  tempId: number;
  tempTitle: string;
  tempContent: string;
  isBeingEdited = false;

  constructor(private notesService: NotesService) {
  }

  ngOnInit(): void {
    this.tempId = this.note.noteId;
    this.tempTitle = this.note.title;
    this.tempContent = this.note.content;
  }

  onEditNote() {
    this.isBeingEdited = true;
    this.tempTitle = this.note.title;
    this.tempContent = this.note.content;
  }

  onSubmit() {
    this.note.title = this.noteForm.value.title;
    this.note.content = this.noteForm.value.content;
    this.notesService.modifyNotes(this.note);
    this.isBeingEdited = false;
  }

  onAbortEdit() {
    this.noteForm.reset();
    this.isBeingEdited = false;
  }

}
