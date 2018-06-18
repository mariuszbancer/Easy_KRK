import {Injectable} from "@angular/core";
import {JsonHttp} from "../auth/json-http";

@Injectable()
export class ChangeSuggestionService{
  constructor(private http: JsonHttp) {
  }

  getAllChangeSuggestions() {
    return this.http.get("/api/changeSuggestions", {})
  }

  createChangeSuggestion(changeSuggestion: any) {
    return this.http.post("/api/changeSuggestions", changeSuggestion, {});
  }
}
