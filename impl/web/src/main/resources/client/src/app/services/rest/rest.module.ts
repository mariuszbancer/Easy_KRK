import {NgModule} from "@angular/core";
import {DepartmentService} from "./department.service";
import {ChangeSuggestionService} from "./changeSuggestion.service";
import {EducationProgramService} from "./educationProgram.service";
import {FieldOfStudyService} from "./fieldOfStudy.service";
import {ModuleService} from "./module.service";
import {CourseService} from "./course.service";

@NgModule({
  imports: [],
  declarations: [],
  exports: [],
  providers: [
    DepartmentService,
    ChangeSuggestionService,
    EducationProgramService,
    FieldOfStudyService,
    ModuleService,
    CourseService
  ]
})
export class RestModule {

}
