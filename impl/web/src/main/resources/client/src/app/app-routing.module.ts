import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes} from "@angular/router";
import {AppComponent} from "./app.component";
import {LoginComponent} from "./auth/login/login.component";
import {PublicPageGuard} from "./services/auth/public-page.guard";
import {RegisterComponent} from "./auth/register/register.component";
import {PrivatePageGuard} from "./services/auth/private-page.guard";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: []
})
export class AppRoutingModule { }

export const routes: Routes = [
  {
    path: 'app',
    component: AppComponent,
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
    path: '',
    redirectTo: 'app',
    pathMatch: 'full'
  }
];
