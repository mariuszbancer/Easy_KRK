import {Component} from "@angular/core";
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth/auth.service";

@Component({
  selector: 'register-component',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  constructor(private router: Router,
              private authService: AuthService) {
    console.log("Register component");
  }

  register(username, password) {
    this.authService.register(username, password)
      .subscribe(() => {
        this.router.navigate(['login']);
      }, e => RegisterComponent.handleError(e));
  }

  static handleError(error) {
    alert("Something went wrong");
  }

}
