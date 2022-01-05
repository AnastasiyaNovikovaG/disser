import {Component, OnInit, OnChanges} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Logbook} from "../../common/logbook";
import {LogbookService} from "../../services/logbook.service";
import {NgbPaginationConfig} from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-logbook-list',
  templateUrl: './logbook-list.component.html',
  styleUrls: ['./logbook-list.component.css']
})
export class LogbookListComponent implements OnInit{

  books: Logbook[] = [];
  currentCategoryId: number = 1;
  previousCategory: number = 1;
  searchMode: boolean = false;

  pageSize: number = 3;
  currentPage: number = 1;
  totalRecords: number = 0;

  constructor(private _logbookService: LogbookService,
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


    /*this.searchMode = this._activatedRoute.snapshot.paramMap.has('keyword');

    if (this.searchMode) {
      this.handleSearchBooks();
    } else {
      this.handleListBooks();
    }*/
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
