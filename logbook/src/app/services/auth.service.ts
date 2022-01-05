import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

const AUTH_API = 'http://localhost:8084/api/auth/'; //url-адрес

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private httpClient: HttpClient) { }

  login(credentials): Observable<any> {
    return this.httpClient.post(AUTH_API + 'signin', {
      username: credentials.username,
      password: credentials.password
    }, httpOptions); //post-запрос с телом
  }

  register(user): Observable<any> {
    return this.httpClient.post(AUTH_API + 'signup', {
      username: user.username,
      email: user.email,
      firstName: user.firstName,
      lastName: user.lastName,
      password: user.password
    }, httpOptions);
  }
}
