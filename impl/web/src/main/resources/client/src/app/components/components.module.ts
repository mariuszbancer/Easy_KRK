import {NgModule} from "@angular/core";
import {HomeComponent} from "./home/home.component";
import {ChangeSuggestionsListComponent} from "./changeSuggestions/change-suggestions-list.component";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CreateChangeSuggestionComponent} from "./changeSuggestions/create-change-suggestion-component";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [
    HomeComponent,
    ChangeSuggestionsListComponent,
    CreateChangeSuggestionComponent
  ],
  exports: [
    HomeComponent,
    ChangeSuggestionsListComponent,
    CreateChangeSuggestionComponent
  ]
})
export class ComponentsModule {

}
