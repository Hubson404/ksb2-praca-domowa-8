import {Component, Input, OnInit, ViewChild} from '@angular/core';
import {NgForm} from "@angular/forms";
import {NotesService} from "../notes.service";

@Component({
  selector: 'app-note-add',
  templateUrl: './note-add.component.html',
  styleUrls: ['./note-add.component.css']
})
export class NoteAddComponent implements OnInit {

  @ViewChild('noteForm') noteForm: NgForm;
  note = {
    noteId: null,
    title: '',
    content: '',
    date: ''
  };
  @Input() isOpen = false;

  constructor(private notesService: NotesService) {
  }

  ngOnInit(): void {
  }

  onAddNote() {
    this.isOpen = true;
  }

  onSubmit() {
    this.note.title = this.noteForm.value.title;
    this.note.content = this.noteForm.value.content;
    this.notesService.createNote(this.note);
    this.isOpen = false;
  }

  onAbortEdit() {
    this.noteForm.reset();
    this.isOpen = false;
  }
}
