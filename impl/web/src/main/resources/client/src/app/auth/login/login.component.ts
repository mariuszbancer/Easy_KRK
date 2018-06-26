import {Component} from "@angular/core";
import {Router} from "@angular/router";
import {AuthService} from "../../services/auth/auth.service";
import {AlertService} from "../../services/alert.service";

@Component({
  selector: 'login-component',
  templateUrl: './login.component.html',
  styles: ["" +
  "body {" +
  "  background-image: url(\"/assets/bg-01.jpg\");" +
  "}"
  ]
})
export class LoginComponent {

  loading = false;
  model: any = {};

  constructor(private router: Router,
              private authService: AuthService,
              private alertService: AlertService) {
  }

  login(username, password) {
    this.authService.login(username, password)
      .subscribe(() => {
      }, e => this.handleError(e));
  }

  handleError(error) {
    this.alertService.error(error);
    this.loading = false;
  }

}
