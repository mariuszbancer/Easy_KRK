import {Injectable} from "@angular/core";
import {JsonHttp} from "../auth/json-http";

@Injectable()
export class CourseService {
  constructor(private http: JsonHttp) {
  }

  getAll() {
    return this.http.get("/api/courses", {});
  }

  createCourse(course: any) {
    return this.http.post("/api/courses", course, {});
  }

  getEnumConstants() {
    return this.http.get("/api/courses/enum", {});
  }
}
