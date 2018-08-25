import {NgModule} from "@angular/core";
import {DepartmentService} from "./department.service";
import {ChangeSuggestionService} from "./changeSuggestion.service";
import {EducationProgramService} from "./educationProgram.service";
import {FieldOfStudyService} from "./fieldOfStudy.service";
import {ModuleService} from "./module.service";
import {SemesterService} from "./semester.service";
import {CourseService} from "./course.service";
import {StudiesProgramService} from "./studiesProgram.service";
import {StudiesPlanService} from "./studiesPlan.service";
import {UsersService} from "./user.service";

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
    SemesterService,
    CourseService,
    CourseService,
    StudiesProgramService,
    StudiesPlanService,
    UsersService
  ]
})
export class RestModule {

}
