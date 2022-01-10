import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Logbook} from "../common/logbook";
import {map} from "rxjs/operators";
import {TypeOfClass} from "../common/typeOfClass";

@Injectable()
export class TypeOfClassService{

  //url-адрес запросов
  private baseUrl = 'http://localhost:8084/type';
  private url='http://localhost:8084/';
  /*  private categoryUrl = 'http://localhost:8084/api/category';
    private universityUrl='http://localhost:8084/api/universities';
    private departmentUrl='http://localhost:8084/api/departments/search';
    private facultyUrl='http://localhost:8084/api/faculties/search';
    private fileUrl = 'http://localhost:8084/api';*/

  constructor(private httpClient: HttpClient) { }

  getTypesList(): Observable<TypeOfClass[]> {
    return this.httpClient.get<GetResponseTypes>(this.baseUrl).pipe(
      map(response => response._embedded.types)
    );
  }

  getAllTypes(): Observable<any> {
    return this.httpClient.get<GetResponseTypes>(this.baseUrl);
  }

  get(typeId: number): Observable<TypeOfClass> {
    const typeDetailsUrl = `${this.baseUrl}/${typeId}`;
    return this.httpClient.get<TypeOfClass>(typeDetailsUrl);
  }

}

//интерфейсы
interface GetResponseTypes {
  _embedded: {
    types: TypeOfClass[];
  },
  page: {
    size: number,
    totalElements: number,
    totalPages: number,
    number:number
  };
}
