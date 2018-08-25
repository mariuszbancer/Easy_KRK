import {Injectable} from "@angular/core";
import {JsonHttp} from "../auth/json-http";

@Injectable()
export class UsersService {

  constructor(private http: JsonHttp) {
  }

  getAll() {
    return this.http.get("/api/users", {});
  }
}
