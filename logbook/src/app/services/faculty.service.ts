import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Faculty} from "../common/faculty";
import {map} from "rxjs/operators";
import {HttpClient, HttpHeaders} from "@angular/common/http";


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class FacultyService {

  private facultyUrl='http://localhost:8084/api/faculties/search';

  constructor(private httpClient: HttpClient) { }

  get(Id: number): Observable<Faculty> {
    const facultiesUrl=`http://localhost:8084/api/faculties/${Id}`;
    return this.httpClient.get<Faculty>(facultiesUrl);
  }

  delete(id: number): Observable<{}> {
    return this.httpClient.delete(`http://localhost:8084/api/faculties/${id}`, httpOptions);
  }

  getFaculties(theUniId: number): Observable<Faculty[]> {
    const facultiesUrl=`${this.facultyUrl}/university?id=${theUniId}`;
    return this.httpClient.get<GetResponseFaculty>(facultiesUrl).pipe(
      map(response => response._embedded.faculties)
    );
  }

  add(faculty): Observable<any> {

    if (faculty.id) {
      return this.httpClient.put(`http://localhost:8084/api/faculties/${faculty.id}`, {
        title: faculty.title,
        shortTitle: faculty.shortTitle,
        university: {
          id: 1,
          title: "Белорусский национальный технический университет",
          shortTitle: "БНТУ"
        }
      }, httpOptions);
    } else {
      return this.httpClient.post(`http://localhost:8084/api/faculties`, {
        title: faculty.title,
        shortTitle: faculty.shortTitle,
        university: {
          id: 1,
          title: "Белорусский национальный технический университет",
          shortTitle: "БНТУ"
        }
      }, httpOptions);
    }
  }

}

interface GetResponseFaculty{
  _embedded: {
    faculties: Faculty[];
  };
}
