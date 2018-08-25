import {Injectable} from "@angular/core";
import {JsonHttp} from "../auth/json-http";

@Injectable()
export class StudiesPlanService {

  constructor(private http: JsonHttp) {
  }

  getAll() {
    return this.http.get("/api/studiesPlans", {});
  }

  create(studiesPlan: any) {
    return this.http.post("/api/studiesPlans", studiesPlan, {});
  }

  update(studiesPlan: any) {
    return this.http.put("/api/studiesPlans", studiesPlan, {});
  }

  getById(id: any) {
    return this.http.get("/api/studiesPlans/" + id, {})
  }
}
