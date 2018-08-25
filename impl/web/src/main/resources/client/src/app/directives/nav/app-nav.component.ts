import {Component} from "@angular/core";
import {AuthService} from "../../services/auth/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-nav',
  templateUrl: './app-nav.component.html'
})
export class AppNavComponent {


  constructor(private authService: AuthService,
              private router: Router) {
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['login']);
  }
}
