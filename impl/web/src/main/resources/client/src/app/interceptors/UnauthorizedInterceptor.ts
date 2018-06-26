import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse
} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {Router} from "@angular/router";
import {catchError, tap} from "rxjs/operators";
import {Injectable} from "@angular/core";
import {throwError} from "rxjs/internal/observable/throwError";
import {AuthService} from "../services/auth/auth.service";

@Injectable()
export class UnauthorizedInterceptor implements HttpInterceptor {

  constructor(private router: Router, private authService: AuthService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
    catchError( err => {
      if (err.status == 401) {
        this.authService.logout();
        this.router.navigate(['login']);
      }
      return throwError(err);
    })
  );
  }
}
