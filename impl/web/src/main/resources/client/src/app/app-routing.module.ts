import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Routes} from "@angular/router";
import {LoginComponent} from "./auth/login/login.component";
import {PublicPageGuard} from "./services/auth/public-page.guard";
import {RegisterComponent} from "./auth/register/register.component";
import {PrivatePageGuard} from "./services/auth/private-page.guard";
import {ChangeSuggestionsListComponent} from "./components/changeSuggestions/change-suggestions-list.component";
import {CreateChangeSuggestionComponent} from "./components/changeSuggestions/create-change-suggestion-component";
import {UpdateChangeSuggestionComponent} from "./components/changeSuggestions/update-change-suggestion-component";
import {CreateEducationProgramComponent} from "./components/educationPrograms/create-education-program-component";
import {EducationProgramsListComponent} from "./components/educationPrograms/education-programs-list.component";
import {CreateModuleComponent} from "./components/modules/create-module.component";
import {CreateSemesterComponent} from "./components/semesters/create-semester.component";
import {CreateCourseComponent} from "./components/courses/create-course.component";
import {CreateStudiesPlanComponent} from "./components/studiesPlans/create-studies-plan.component";
import {CreateStudiesProgramComponent} from "./components/studiesPrograms/create-studies-program.component";
import {UpdateStudiesProgramComponent} from "./components/studiesPrograms/update-studies-program.component";
import {UpdateStudiesPlanComponent} from "./components/studiesPlans/update-studies-plan-component";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: []
})
export class AppRoutingModule { }

export const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [PublicPageGuard]
  },
  {
    path: 'register',
    component: RegisterComponent,
    canActivate: [PublicPageGuard]
  },
  {
    path: 'changesSuggestions',
    component: ChangeSuggestionsListComponent,
    canActivate: [PrivatePageGuard]
  },
  {
    path: 'createChangeSuggestion',
    component: CreateChangeSuggestionComponent,
    canActivate: [PrivatePageGuard]
  },
  {
    path: 'updateChangeSuggestion/:id',
    component: UpdateChangeSuggestionComponent,
    canActivate: [PrivatePageGuard]
  },
  {
    path: 'createEducationProgram',
    component: CreateEducationProgramComponent,
    canActivate: [PrivatePageGuard]
  },
  {
    path: 'educationPrograms',
    component: EducationProgramsListComponent,
    canActivate: [PrivatePageGuard]
  },
  {
    path: 'createModule',
    component: CreateModuleComponent,
    canActivate: [PrivatePageGuard]
  },
  {
    path: 'createSemester',
    component: CreateSemesterComponent,
    canActivate: [PrivatePageGuard]
  },
  {
    path: 'createCourse',
    component: CreateCourseComponent,
    canActivate: [PrivatePageGuard]
  },
  {
    path: "createStudiesPlan",
    component: CreateStudiesPlanComponent,
    canActivate: [PrivatePageGuard]
  },
  {
    path: "updateStudiesPlan/:id",
    component: UpdateStudiesPlanComponent,
    canActivate: [PrivatePageGuard]
  },
  {
    path: "createStudiesProgram",
    component: CreateStudiesProgramComponent,
    canActivate: [PrivatePageGuard]
  },
  {
    path: "updateStudiesProgram/:id",
    component: UpdateStudiesProgramComponent,
    canActivate: [PrivatePageGuard]
  },
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  }
];
