import {Injectable} from "@angular/core";
import {JsonHttp} from "../auth/json-http";

@Injectable()
export class EducationProgramService {
  constructor(private http: JsonHttp) {
  }

  getById(id: number) {
    return this.http.get("/api/educationPrograms/" + id, {})
  }

  getAllEducationPrograms() {
    return this.http.get("/api/educationPrograms", {})
  }

  createEducationProgram(educationProgram: any) {
    return this.http.post("/api/educationPrograms", educationProgram, {});
  }

  updateEducationProgram(educationProgram: any) {
    return this.http.put("/api/educationPrograms", educationProgram, {})
  }

  deleteById(id: null) {
    return this.http.delete("/api/educationPrograms/" + id, {});
  }
}
