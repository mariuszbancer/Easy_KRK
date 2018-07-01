import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {AppRoutingModule, routes} from './app-routing.module';
import {RouterModule} from "@angular/router";
import {LoginModule} from "./auth/login/login.module";
import {RegisterModule} from "./auth/register/register.module";
import {PrivatePageGuard} from "./services/auth/private-page.guard";
import {PublicPageGuard} from "./services/auth/public-page.guard";
import {JsonHttp} from "./services/auth/json-http";
import {AuthService} from "./services/auth/auth.service";
import {JwtInterceptor} from "./interceptors/JwtInterceptor";
import {AlertComponent} from "./directives/alert/alert.component";
import {AlertService} from "./services/alert.service";
import {AppNavComponent} from "./directives/nav/app-nav.component";
import {ComponentsModule} from "./components/components.module";
import {RestModule} from "./services/rest/rest.module";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {UnauthorizedInterceptor} from "./interceptors/UnauthorizedInterceptor";


@NgModule({
  declarations: [
    AppComponent,
    AlertComponent,
    AppNavComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    AppRoutingModule,
    LoginModule,
    RegisterModule,
    ComponentsModule,
    RestModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
    AuthService,
    JsonHttp,
    PrivatePageGuard,
    PublicPageGuard,
    AlertService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptor,
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: UnauthorizedInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
