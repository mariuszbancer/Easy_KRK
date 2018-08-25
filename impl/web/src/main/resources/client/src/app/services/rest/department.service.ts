import {Injectable} from "@angular/core";
import {JsonHttp} from "../auth/json-http";

@Injectable()
export class DepartmentService{
  constructor(private http: JsonHttp) {
  }

  getAllDepartments() {
    return this.http.get("/api/departments", {})
  }

  getFieldOfStudiesByDepartment(departmentId: number) {
    return this.http.get("/api/departments/" + departmentId + "/fieldOfStudies", {});
  }
}
