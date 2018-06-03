import {Injectable} from "@angular/core";
import {Router} from "@angular/router";
import {AuthService} from "./auth.service";
import {ObservableInput} from "rxjs/internal/types";
import {Observable} from "rxjs/internal/Observable";

@Injectable()
export class HttpErrorHandler {

  constructor(private router: Router,
              private authService: AuthService) {
  }

  handle(error: any): ObservableInput<{}> {
    if (error.status === 401) {
      this.authService.logout();
      this.router.navigate(['login']);
    }
    return Observable.throw(error.json().error || 'Server error');
  }

}
