import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {BookCategory} from "../common/book-category";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Department} from "../common/department";
import {map} from "rxjs/operators";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  private departmentUrl='http://localhost:8084/api/departments/search';

  constructor(private httpClient: HttpClient) { }

  getDepartments(theFacultyId): Observable<Department[]> {
    const departmentsUrl=`${this.departmentUrl}/faculty?id=${theFacultyId}`;
    return this.httpClient.get<GetResponseDepartment>(departmentsUrl).pipe(
      map(response => response._embedded.departments)
    );
  }

  getAllDepartments(): Observable<any> {
    const allDepartmentsUrl=`http://localhost:8084/api/departments/`;
    return this.httpClient.get(allDepartmentsUrl);
  }

  get(Id: number): Observable<Department> {
    const departmentUrl=`http://localhost:8084/api/departments/${Id}`;
    return this.httpClient.get<Department>(departmentUrl);
  }

  delete(id:number): Observable<{}>{
    return this.httpClient.delete(`http://localhost:8084/api/departments/${id}`, httpOptions);
  }

  add(department, faculty): Observable<any> {

    if (department.id) {
      return this.httpClient.put(`http://localhost:8084/api/departments/${department.id}`, {
        title: department.title,
        shortTitle: department.shortTitle,
        faculty: {
          id: faculty.id
        }
      }, httpOptions);
    } else {
      return this.httpClient.post(`http://localhost:8084/api/departments`, {
        title: department.title,
        shortTitle: department.shortTitle,
        faculty: {
          id: faculty
        }
      }, httpOptions);
    }
  }
}

interface GetResponseDepartment {
  _embedded: {
    departments: Department[];
  };
}
