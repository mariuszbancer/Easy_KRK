import {NgModule} from "@angular/core";
import {HomeComponent} from "./home/home.component";
import {ChangeSuggestionsListComponent} from "./changeSuggestions/change-suggestions-list.component";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [
    HomeComponent,
    ChangeSuggestionsListComponent
  ],
  exports: [
    HomeComponent,
    ChangeSuggestionsListComponent
  ]
})
export class ComponentsModule {

}
