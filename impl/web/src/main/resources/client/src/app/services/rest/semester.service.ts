import {Injectable} from "@angular/core";
import {JsonHttp} from "../auth/json-http";

@Injectable()
export class SemesterService {

  constructor(private http: JsonHttp) {
  }

  createSemester(semester: any) {
    return this.http.post("/api/semesters", semester, {});
  }

  getAll() {
    return this.http.get("/api/semesters", {});
  }
}
