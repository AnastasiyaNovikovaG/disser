import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Logbook} from "../common/logbook";
import {map} from "rxjs/operators";
import {TypeOfClass} from "../common/typeOfClass";


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token'
  })
};

const httpDelOptions= {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'API-Key': 'secret'
  })
}

@Injectable({
  providedIn: 'root'
})
export class LogbookService{

  //url-адрес запросов
  private baseUrl = 'http://localhost:8084/logbook';
  private url='http://localhost:8084/';
  private typeUrl = 'http://localhost:8084/type';
/*  private categoryUrl = 'http://localhost:8084/api/category';
  private universityUrl='http://localhost:8084/api/universities';
  private departmentUrl='http://localhost:8084/api/departments/search';
  private facultyUrl='http://localhost:8084/api/faculties/search';
  private fileUrl = 'http://localhost:8084/api';*/

  constructor(private httpClient: HttpClient) { }

  getBooks(theCategoryId: number, currentPage: number, pageSize: number): Observable<GetResponseBooks> {
    const searchUrl = `${this.baseUrl}/search/category?id=${theCategoryId}&page=${currentPage}&size=${pageSize}`;
    return this.httpClient.get<GetResponseBooks>(searchUrl);//get-запрос
  }

  getLogBooksByMonth(theMonthId:number, currentPage: number, pageSize: number): Observable<GetResponseBooks>{
    const monthUrl = `${this.baseUrl}/month?id=${theMonthId}&page=${currentPage}&size=${pageSize}`;
    return this.httpClient.get<GetResponseBooks>(monthUrl);
  }

  getLogBooksByMonthAndIdTeach(theMonthId:number, theTeachId:number, currentPage: number, pageSize: number): Observable<GetResponseBooks>{
    const monthAndTeachUrl = `${this.baseUrl}/my/teacher?id=${theTeachId}/teacher?id=${theTeachId}&page=${currentPage}&size=${pageSize}`;
    return this.httpClient.get<GetResponseBooks>(monthAndTeachUrl);
  }

  getBooksByDepartment(theDepartmentId: number, currentPage: number, pageSize: number): Observable<GetResponseBooks> {
    const searchUrl = `${this.baseUrl}/search/department?id=${theDepartmentId}&page=${currentPage}&size=${pageSize}`;
    return this.httpClient.get<GetResponseBooks>(searchUrl);
  }

  getBooksByAuthor(theAuthorId: number, currentPage: number, pageSize: number): Observable<GetResponseBooks> {
    const searchUrl = `${this.baseUrl}/search/author?id=${theAuthorId}&page=${currentPage}&size=${pageSize}`;
    return this.httpClient.get<GetResponseBooks>(searchUrl);
  }

  getBooksList(): Observable<Logbook[]> {
    return this.httpClient.get<GetResponseBooks>(this.baseUrl).pipe(
      map(response => response._embedded.books)
    );
  }

  getAllBooks(): Observable<any> {
    return this.httpClient.get<GetResponseBooks>(this.baseUrl);
  }

  getBookTypes(): Observable<TypeOfClass[]> {
    return this.httpClient.get<GetResponseType>(this.typeUrl).pipe(
      map(response => response._embedded.type)
    );
  }

  /*
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

    searchBooks(keyword: string, currentPage: number, pageSize: number): Observable<GetResponseBooks> {
      const searchUrl = `${this.baseUrl}/search/searchbykeyword?title=${keyword}&page=${currentPage}&size=${pageSize}`;
      return this.httpClient.get<GetResponseBooks>(searchUrl);
    }*/

  get(bookId: number): Observable<Logbook> {
    const bookDetailsUrl = `${this.baseUrl}/${bookId}`;
    return this.httpClient.get<Logbook>(bookDetailsUrl);
  }


 /* getFaculties(theUniId: number): Observable<Faculty[]> {
    const facultiesUrl=`${this.facultyUrl}/university?id=${theUniId}`;
    return this.httpClient.get<GetResponseFaculty>(facultiesUrl).pipe(
      map(response => response._embedded.faculties)
    );
  }*/

 /* getAuthors(): Observable<User[]> {
    const authorsUrl=`http://localhost:8084/api/roles/2/users`;
    return this.httpClient.get<GetResponseAuthor>(authorsUrl).pipe(
      map(response => response._embedded.users)
    );
  }*/

  add(logbook): Observable<any> {
    if (logbook.id) {
      return this.httpClient.put(`${this.baseUrl}/${logbook.id}`, {
        date : logbook.date,
        idType : logbook.idType,
        idSubj: logbook.idSubj,
        hours : logbook.hours,
        idTeach: logbook.idTeach,
        idSem: logbook.idSem,
        monthsId: logbook.monthsId,
        departmentId: logbook.departmentId,
       /* category: {
          id : category.id
        },
        department: {
          id:department.id
        }*/
      }, httpOptions); //put-запрос с телом
    }
    else{
      return this.httpClient.post(this.baseUrl, {
        date : logbook.date,
        idType : logbook.idType,
        idSubj: logbook.idSubj,
        hours : logbook.hours,
        idTeach: logbook.idTeach,
        idSem: logbook.idSem,
        monthsId: logbook.monthsId,
        departmentId: logbook.departmentId,
        /* category: {
           id : category.id
         },
         department: {
           id:department.id
         }*/
      }, httpOptions);} //post-запрос с телом
  }


 /* upload(file: File): Observable<HttpEvent<any>> {
    const formData: FormData = new FormData();

    formData.append('file', file);

    const req = new HttpRequest('POST', `${this.fileUrl}/upload`, formData, {
      reportProgress: true,
      responseType: 'json'
    });

    return this.httpClient.request(req);//post-запрос
  }
*/
 /* getFiles(): Observable<any> {
    return this.httpClient.get(`${this.fileUrl}/files`);
  }*/

  delete(id: number): Observable<{}> {
    return this.httpClient.delete(`${this.baseUrl}/${id}`, httpOptions);//delete-запрос
  }

  /*download(fileName): Observable<any> {
    return this.httpClient.get(`http://localhost:8084/api/files/${fileName}`);
  }*/


}

//интерфейсы
interface GetResponseBooks {
  _embedded: {
    books: Logbook[];
  },
  page: {
    size: number,
    totalElements: number,
    totalPages: number,
    number:number
  };
}

interface GetResponseType{
  _embedded: {
    type: TypeOfClass[];
  };
}

/*
interface GetResponseAuthor {
  _embedded: {
    users: User[];
  };
}

interface GetResponseDepartment {
  _embedded: {
    departments: Department[];
  };
}

interface GetResponseFaculty{
  _embedded: {
    faculties: Faculty[];
  };
}*/


