import {Injectable} from "@angular/core";
import {JsonHttp} from "../auth/json-http";

@Injectable()
export class StudiesProgramService {

  constructor(private http: JsonHttp) {
  }

  getAll() {
    return this.http.get("/api/studiesPrograms", {});
  }

  create(studiesProfile: any) {
    return this.http.post("/api/studiesPrograms", studiesProfile, {});
  }
}
