import {Injectable} from "@angular/core";
import {JsonHttp} from "../auth/json-http";

@Injectable()
export class StudiesProgramService {

  constructor(private http: JsonHttp) {
  }

  getAll() {
    return this.http.get("/api/studiesPrograms", {});
  }

  create(studiesProgram: any) {
    return this.http.post("/api/studiesPrograms", studiesProgram, {});
  }

  update(studiesProgram: any) {
    return this.http.put("/api/studiesPrograms", studiesProgram, {});
  }

  getById(id: any) {
    return this.http.get("/api/studiesPrograms/" + id, {});
  }
}
