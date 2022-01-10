/*
import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {TokenStorageService} from "../../services/token-storage.service";

@Component({
  selector: 'app-board-author',
  templateUrl: './board-author.component.html',
  styleUrls: ['./board-author.component.css']
})
export class BoardAuthorComponent implements OnInit {

  content = '';
  userId: number;
  constructor(private userService: UserService,
              private tokenStorageService: TokenStorageService) { }

  ngOnInit() {
    const user = this.tokenStorageService.getUser();
    this.userId = user.id;
    this.userService.getAuthorBoard().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }

}
*/
