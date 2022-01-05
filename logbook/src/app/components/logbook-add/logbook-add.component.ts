import {Component, OnInit, OnChanges} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Logbook} from "../../common/logbook";
import {LogbookService} from "../../services/logbook.service";
import {HttpClient} from "@angular/common/http";
import {TokenStorageService} from "../../services/token-storage.service";


@Component({
  selector: 'app-logbook-add',
  templateUrl: './logbook-add.component.html',
  styleUrls: ['./logbook-add.component.css']
})
export class LogbookAddComponent implements OnInit{

  logbookForm: any = {
    date : '',
    idType : '',
    idSubj: '',
    hours : '',
    idTeach: '',
    idSem: '',
    monthsId: '',
    departmentId: ''
  };

  book: Logbook;
  books: Logbook[] = [];
  hasBookID: number;
  currentBookId: number = 1;
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';
  //bookCategories: BookCategory[];
  //departments: Department[];
  progress = 0;
  message = '';
  isBook = false;
 // category: BookCategory;
  //department: Department;

//  fileInfos: Observable<any>;

  private roles: string[];
  showAdminBoard = false;
  showTeacherBoard = false;
  //private httpService: any;

  constructor(private _logBookService: LogbookService,
              //private _categoryService: CategoryService,
              //private _departmentService: DepartmentService,
              private httpClient: HttpClient,
              private _activatedRoute: ActivatedRoute,
              private tokenStorageService: TokenStorageService) {
  }

  ngOnInit() {
    //this.fileInfos = this._bookService.getFiles();
    const hasBookID: boolean = this._activatedRoute.snapshot.paramMap.has('id');

    if (hasBookID) {
      this.currentBookId = + this._activatedRoute.snapshot.paramMap.get('id');
      this._logBookService.get(this.currentBookId)
        .subscribe(data => this.logbookForm = data);
      this.isBook = true;
    } else {
      /*this._logBookService.getBookCategories().subscribe(
        data => this.bookCategories = data
      );
      this._bookService.getAllDepartments().subscribe(
        data => this.departments = data
      );*/

    }

    const user = this.tokenStorageService.getUser();
    this.roles = user.roles;

    this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
    this.showTeacherBoard = this.roles.includes('ROLE_TEACHER');

  }

  onSubmit() {
    /*this._categoryService.get(this.bookForm.category).subscribe(
      data =>{ this.category = data}
    );
    this._departmentService.get(this.bookForm.department).subscribe(
      data =>{ this.department = data}
    );*/
    this._logBookService.add(this.logbookForm).subscribe(
      data => {
        console.log(data);
        this.isSuccessful = true;
        this.isSignUpFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }

  /*selectFile(event) {
    this.selectedFiles = event.target.files;
  }*/


/*  upload() {
    this.progress = 0;

    //this.currentFile = this.selectedFiles.item(0);
    //this.fileName = this.currentFile.name;
    this._logBookService.upload(this.currentFile).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.progress = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          this.message = event.body.message;
          this.fileInfos = this._bookService.getFiles();
        }
      },
      err => {
        this.progress = 0;
        this.message = 'Could not upload the file!';
        this.currentFile = undefined;
      });

    this.selectedFiles = undefined;
  }*/

  /*
  logbooks: Logbook[];
  statusMessage: string;
  logbook = new Logbook();

  constructor(private _logbookService: LogbookService,
              private _router: Router){}

  ngOnInit(): void {
    console.log("calling ngOnInit()::::");
    this.getLogbooks();
  }

  getLogbooks(): void{
    console.log("Inside getBooks():::::")
    this._logbookService.getAllLogbooks()
      .subscribe((logbookData) => this.logbooks = logbookData,
        (error) =>{
          console.log(error);
          this.statusMessage = "Problem with service. Please try again later!";
        }
      );
    console.log("end of getBooks():::::");
  }

  addLogbook(): void{
    console.log("inside the addBook()::::::")
    this._logbookService.addLogbook(this.logbook)
      .subscribe((response) => {console.log(response); this.getLogbooks();this.reset();},
        (error) =>{
          console.log(error);
          this.statusMessage = "Problem with service. Please try again later!";
        }
      );

    console.log("end of addBook()::::");
    //this._router.navigate(['/books']);
  }

  private reset(){
    console.log("inside the reset():::::::");
    this.logbook.id = null;
    this.logbook.date = null;
    this.logbook.hours = null;
    this.logbook.departmentId = null;
    this.logbook.idSem = null;
    this.logbook.idSubj = null;
    console.log("end of reset():::::::");
  }

  ngOnChanges(changes:any) {
    console.log("calling ngOnChanges()::::::::");
  }

  deleteBook(bookId: string){
    console.log("Inside the deleteBook()::::Book id::::"+bookId);
    this._logbookService.deleteBook(bookId)
      .subscribe((response) => {console.log(response); this.getLogbooks();},
        (error) =>{
          console.log(error);
          this.statusMessage = "Problem with service. Please try again later!";
        });
    this.reset();
    console.log("end of deleteBook():::::::");
  }

  getBook(bookId: string){
    console.log("Inside the updateBook()::::::Book id::::"+bookId);
    this._logbookService.getBookById(bookId)
      .subscribe((bookData) => {this.logbook = bookData; this.getLogbooks(); }),
      (error) => {
        console.log(error);
        this.statusMessage = "Problem with service. Please try again later!";
      }
    this.reset();
    console.log("end of updateBook()::::::");
  }*/
}
