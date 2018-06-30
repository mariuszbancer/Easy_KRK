import {NgModule} from "@angular/core";
import {HomeComponent} from "./home/home.component";
import {ChangeSuggestionsListComponent} from "./changeSuggestions/change-suggestions-list.component";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CreateChangeSuggestionComponent} from "./changeSuggestions/create-change-suggestion-component";
import {UpdateChangeSuggestionComponent} from "./changeSuggestions/update-change-suggestion-component";
import {CreateEducationProgramComponent} from "./educationPrograms/create-education-program-component";
import {EducationProgramsListComponent} from "./educationPrograms/education-programs-list.component";
import {CreateModuleComponent} from "./modules/create-module.component";
import {CreateCourseComponent} from "./courses/create-course.component";
import {CreateStudiesPlanComponent} from "./studiesPlans/create-studies-plan.component";
import {CreateStudiesProgramComponent} from "./studiesPrograms/create-studies-program.component";

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
    CreateEducationProgramComponent,
    EducationProgramsListComponent,
    CreateModuleComponent,
    CreateCourseComponent,
    CreateStudiesPlanComponent,
    CreateStudiesProgramComponent
  ],
  exports: [
    HomeComponent,
    ChangeSuggestionsListComponent,
    CreateChangeSuggestionComponent,
    UpdateChangeSuggestionComponent,
    CreateEducationProgramComponent,
    EducationProgramsListComponent,
    CreateModuleComponent,
    CreateCourseComponent,
    CreateStudiesPlanComponent,
    CreateStudiesProgramComponent
  ]
})
export class ComponentsModule {

}
