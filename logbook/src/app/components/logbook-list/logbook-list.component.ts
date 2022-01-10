import {Component, OnInit, OnChanges} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Logbook} from "../../common/logbook";
import {LogbookService} from "../../services/logbook.service";
import {NgbPaginationConfig} from '@ng-bootstrap/ng-bootstrap';
import {TypeOfClass} from "../../common/typeOfClass";
import {TypeOfClassService} from "../../services/typeOfClass.service";


@Component({
  selector: 'app-logbook-list',
  templateUrl: './logbook-list.component.html',
  styleUrls: ['./logbook-list.component.css']
})
export class LogbookListComponent implements OnInit{


  books: Logbook[] = [];
  info: Logbook = new Logbook();
  type: TypeOfClass = new TypeOfClass();
  currentCategoryId: number = 1;
  previousCategory: number = 1;
  searchMode: boolean = false;
  pageSize: number = 3;
  currentPage: number = 1;
  totalRecords: number = 0;

  constructor(private _logbookService: LogbookService,
              private _typeOfClassService: TypeOfClassService,
              private _activatedRoute: ActivatedRoute,
              config: NgbPaginationConfig){
    config.boundaryLinks = true;
    config.maxSize = 3;
  }


  ngOnInit() {
    this._activatedRoute.paramMap.subscribe(() => {
      this.listBooks();
    });
  }



  listBooks() {
    this._logbookService.getAllBooks().subscribe(
      data => this.books = data
    );


   /* this._logbookService.getBooksList().subscribe(
      data => this.books = data
    );*/
    //this.books.forEach(this.getBookInfo())

  }

  typeOfClassSearch(typeId: number) {
    this._typeOfClassService.get(typeId).subscribe(
      data=>this.type = data
    );
  }

  getBookInfo(id:number) {

    //const id: number = + this._activatedRoute.snapshot.paramMap.get('id');

    this._logbookService.get(id).subscribe(
      data => {
        this.info = data;
      }
    );
  }

  handleListBooks() {
    const hasCategoryId: boolean = this._activatedRoute.snapshot.paramMap.has('id');

    if (hasCategoryId) {
      this.currentCategoryId = + this._activatedRoute.snapshot.paramMap.get('id');
    } else {
      this.currentCategoryId = 1;
    }

    if(this.previousCategory != this.currentCategoryId) {
      this.currentPage = 1;
    }

    this.previousCategory = this.currentCategoryId;

    this._logbookService.getBooks(this.currentCategoryId,
      this.currentPage - 1,
      this.pageSize).subscribe(
      this.processPaginate()
    );
  }

  processPaginate(){
    return data => {
      this.books = data._embedded.books;
      this.currentPage = data.page.number + 1;
      this.totalRecords = data.page.totalElements;
      this.pageSize = data.page.size;
    }
  }

  /*handleSearchBooks() {
    const keyword: string = this._activatedRoute.snapshot.paramMap.get('keyword');

    this._logbookService.searchBooks(keyword,
      this.currentPage - 1,
      this.pageSize)
      .subscribe(this.processPaginate());
  }*/

  updatePageSize(pageSize: number) {
    this.pageSize = pageSize;
    this.currentPage = 1;
    this.listBooks();
  }
}
