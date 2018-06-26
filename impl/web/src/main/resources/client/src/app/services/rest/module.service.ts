import {Injectable} from "@angular/core";
import {JsonHttp} from "../auth/json-http";

@Injectable()
export class ModuleService {

  constructor(private http: JsonHttp) {
  }

  createModule(module: any) {
    return this.http.post("/api/modules", module, {});
  }
}
