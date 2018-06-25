import {Injectable} from "@angular/core";
import {JsonHttp} from "../auth/json-http";

@Injectable()
export class ChangeSuggestionService{
  constructor(private http: JsonHttp) {
  }

  getById(id: number) {
    return this.http.get("/api/changeSuggestions/" + id, {})
  }

  getAllChangeSuggestions() {
    return this.http.get("/api/changeSuggestions", {})
  }

  createChangeSuggestion(changeSuggestion: any) {
    return this.http.post("/api/changeSuggestions", changeSuggestion, {});
  }

  updateChangeSuggestion(changeSuggestion: any) {
    return this.http.put("/api/changeSuggestions", changeSuggestion, {})
  }

  deleteById(id: null) {
    return this.http.delete("/api/changeSuggestions/" + id, {});
  }
}
