import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule, Routes} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {HttpModule} from "@angular/http";
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import {LogbookAddComponent} from "./components/logbook-add/logbook-add.component";
import {LogbookService} from "./services/logbook.service";
import {LogbookListComponent} from "./components/logbook-list/logbook-list.component";
import {PageNotFoundComponent} from "./components/page-not-found/page-not-found.component";

const routes: Routes = [
  {path: 'logbook/add', component: LogbookAddComponent},
  {path: 'logbook', component: LogbookListComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent, LogbookAddComponent, LogbookListComponent, PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    NgbModule
  ],
  providers: [LogbookService],
  bootstrap: [AppComponent]
})
export class AppModule { }
