import {Injectable} from "@angular/core";
import {JsonHttp} from "../auth/json-http";

@Injectable()
export class ModuleService {

  constructor(private http: JsonHttp) {
  }

  getAllModules() {
    return this.http.get("/api/modules", {});
  }

  createModule(module: any) {
    return this.http.post("/api/modules", module, {});
  }
}
