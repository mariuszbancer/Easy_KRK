import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {Routes} from "@angular/router";
import {LoginComponent} from "./auth/login/login.component";
import {PublicPageGuard} from "./services/auth/public-page.guard";
import {RegisterComponent} from "./auth/register/register.component";
import {PrivatePageGuard} from "./services/auth/private-page.guard";
import {HomeComponent} from "./components/home/home.component";
import {ChangeSuggestionsListComponent} from "./components/changeSuggestions/change-suggestions-list.component";
import {CreateChangeSuggestionComponent} from "./components/changeSuggestions/create-change-suggestion-component";
import {UpdateChangeSuggestionComponent} from "./components/changeSuggestions/update-change-suggestion-component";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: []
})
export class AppRoutingModule { }

export const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [PrivatePageGuard]
  },
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
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  }
];
