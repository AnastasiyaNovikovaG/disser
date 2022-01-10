import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from "../common/user";
import {map} from "rxjs/operators";
import {Role} from "../common/role";

const API_URL = 'http://localhost:8084/api/test';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  getPublicContent(): Observable<any> {
    return this.httpClient.get(API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.httpClient.get(API_URL + 'user', { responseType: 'text' });
  }

  getAuthorBoard(): Observable<any> {
    return this.httpClient.get(API_URL + 'author', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.httpClient.get(API_URL + 'admin', { responseType: 'text' });
  }

  getUsers(): Observable<User[]> {
    const authorsUrl=`http://localhost:8084/api/users`;
    return this.httpClient.get<GetResponseAuthor>(authorsUrl).pipe(
      map(response => response._embedded.users)
    );
  }

  getUser(theUserId:number): Observable<User> {
    const userDetailsUrl = `http://localhost:8084/api/users/${theUserId}`;
    return this.httpClient.get<User>(userDetailsUrl);
  }


  getUserRole(theUserId): Observable<Role[]> {
    const roleUrl=`http://localhost:8084/api/users/${theUserId}/roles`;
    return this.httpClient.get<GetResponseRole>(roleUrl).pipe(
      map(response => response._embedded.roles)
    );
  }

  modifyUserRole(theUserId, roleId): Observable<any>{
    const url=`http://localhost:8084/api/users/rolesAdd/${theUserId}`;
    return this.httpClient.post(url, roleId, httpOptions);
  }
}

interface GetResponseAuthor {
  _embedded: {
    users: User[];
  };
}

interface GetResponseRole {
  _embedded: {
    roles: Role[];
  };
}
