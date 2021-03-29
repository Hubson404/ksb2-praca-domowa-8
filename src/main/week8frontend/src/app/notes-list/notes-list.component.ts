import {Component, OnInit} from '@angular/core';
import {NotesService} from "./notes.service";

@Component({
  selector: 'app-news-list',
  templateUrl: './notes-list.component.html',
  styleUrls: ['./notes-list.component.css']
})
export class NotesListComponent implements OnInit {

  notes = [];

  constructor(private notesService: NotesService) {
  }

  ngOnInit(): void {
    this.onFetchNotes();
  }

  onFetchNotes() {
    this.notesService.getNotes().subscribe(response => {
      this.notes = response;
    })
  }

}
