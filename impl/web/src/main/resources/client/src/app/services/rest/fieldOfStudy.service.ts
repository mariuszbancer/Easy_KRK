import {Injectable} from "@angular/core";
import {JsonHttp} from "../auth/json-http";

@Injectable()
export class FieldOfStudyService {
  constructor(private http: JsonHttp) {
  }

  getById(id: number) {
    return this.http.get("/api/fieldOfStudies/" + id, {})
  }

  getAll() {
    return this.http.get("/api/fieldOfStudies", {})
  }

  getAllFieldOfStudies() {
    return this.http.get("/api/fieldOfStudies", {})
  }

  createFieldOfStudy(fieldOfStudy: any) {
    return this.http.post("/api/fieldOfStudies", fieldOfStudy, {});
  }

  updateFieldOfStudy(fieldOfStudy: any) {
    return this.http.put("/api/fieldOfStudies", fieldOfStudy, {})
  }

  deleteById(id: null) {
    return this.http.delete("/api/fieldOfStudies/" + id, {});
  }
}
