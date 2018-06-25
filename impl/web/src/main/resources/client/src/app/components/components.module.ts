import {NgModule} from "@angular/core";
import {HomeComponent} from "./home/home.component";
import {ChangeSuggestionsListComponent} from "./changeSuggestions/change-suggestions-list.component";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CreateChangeSuggestionComponent} from "./changeSuggestions/create-change-suggestion-component";
import {UpdateChangeSuggestionComponent} from "./changeSuggestions/update-change-suggestion-component";
import {CreateEducationProgramComponent} from "./educationPrograms/create-education-program-component";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [
    HomeComponent,
    ChangeSuggestionsListComponent,
    CreateChangeSuggestionComponent,
    UpdateChangeSuggestionComponent,
    CreateEducationProgramComponent
  ],
  exports: [
    HomeComponent,
    ChangeSuggestionsListComponent,
    CreateChangeSuggestionComponent,
    UpdateChangeSuggestionComponent,
    CreateEducationProgramComponent
  ]
})
export class ComponentsModule {

}