import {NgModule} from "@angular/core";
import {HomeComponent} from "./home/home.component";
import {ChangeSuggestionsListComponent} from "./changeSuggestions/change-suggestions-list.component";

@NgModule({
  imports: [],
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
