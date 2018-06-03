import {Subject} from "rxjs/internal/Subject";

declare var require: any;

import {Injectable} from "@angular/core";
import {JsonHttp} from "./json-http";
import {Observable} from "rxjs/internal/Observable";

@Injectable()
export class AuthService {

  private authEvents: Subject<AuthEvent>;

  constructor(private http: JsonHttp) {
    this.authEvents = new Subject<AuthEvent>();
  }

  register(username: any, password: any) {
    const body = {
      username: username,
      password: password,
    };
    let observable = this.http.post('/api/register', body, {});
    observable.subscribe(resp  => {
      this.authEvents.next(new DidRegister())
    });
    return observable;
  }

  login(username: string, password: string) {
    const body = {
      username: username,
      password: password,
    };
    let observable = this.http.post('/api/login', body, {});
    observable
      .subscribe((resp: any) => {
      localStorage.setItem('jwt', resp.token);
      this.authEvents.next(new DidLogin());
    });
    return observable;
  }

  logout(): void {
    localStorage.removeItem('jwt');
    this.authEvents.next(new DidLogout());
  }

  isSignedIn(): boolean {
    return localStorage.getItem('jwt') !== null;
  }

  get events(): Observable<AuthEvent> {
    return this.authEvents;
  }
}

export class DidRegister {
}
export class DidLogin {
}
export class DidLogout {
}

export type AuthEvent = DidLogin | DidLogout;
