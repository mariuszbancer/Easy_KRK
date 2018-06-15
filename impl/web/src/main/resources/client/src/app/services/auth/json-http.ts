import {Injectable} from "@angular/core";
import {Observable} from "rxjs/internal/Observable";
import {HttpClient, HttpHeaders} from "@angular/common/http";

const mergeAuthToken = (options) => {
  let newOptions = Object.assign({}, options);
  let newHeaders = new HttpHeaders(newOptions.headers);
  const jwt = localStorage.getItem('jwt');
  if (jwt) {
    newHeaders.set('Authorization', `Bearer ${jwt}`);
  }
  newOptions.headers = newHeaders;
  return newOptions;
};

@Injectable()
export class JsonHttp {

  constructor(private http: HttpClient) {
  }

  get(url: string, options) {
    return this.http.get(url, mergeAuthToken(options));
  }

  post(url: string, body: any, options) {
    return this.http.post(url, body, mergeAuthToken(options));
  }

  put(url: string, body: any, options) {
    return this.http.put(url, body, mergeAuthToken(options));
  }

  delete(url: string, options) {
    return this.http.delete(url, mergeAuthToken(options));
  }

  patch(url: string, body: any, options) {
    return this.http.patch(url, body, mergeAuthToken(options));
  }

  head(url: string, options) {
    return this.http.head(url, mergeAuthToken(options));
  }

}
