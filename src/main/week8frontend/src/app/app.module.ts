import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {ForecastComponent} from "./forecast/forecast.component";
import {NotesListComponent} from "./notes-list/notes-list.component";
import {NoteComponent} from "./notes-list/note-element/note.component";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {NoteAddComponent} from "./notes-list/note-add/note-add.component";

@NgModule({
  declarations: [
    AppComponent,
    ForecastComponent,
    NotesListComponent,
    NoteComponent,
    NoteAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
