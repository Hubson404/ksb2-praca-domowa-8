import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ForecastComponent} from "./forecast/forecast.component";
import {NotesListComponent} from "./notes-list/notes-list.component";

const routes: Routes = [
  {path: 'forecasts', component: ForecastComponent},
  {path: 'notes', component: NotesListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
