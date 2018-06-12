import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core";
import {RouterModule} from "@angular/router";
import {RegisterComponent} from "./register.component";

@NgModule({
  imports: [
    CommonModule,
    RouterModule
  ],
  declarations: [
    RegisterComponent,
  ],
  exports: [
    RegisterComponent,
  ]
})
export class RegisterModule {
}
