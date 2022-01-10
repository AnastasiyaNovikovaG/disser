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
import {HomeComponent} from "./components/home/home.component";
import {LoginComponent} from "./components/login/login.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {RegisterComponent} from "./components/register/register.component";
import {authInterceptorProviders} from "./helpers/auth.interceptor";
import {TypeOfClassService} from "./services/typeOfClass.service";

const routes: Routes = [
  {path: 'logbook/add', component: LogbookAddComponent},
  {path: 'logbook', component: LogbookListComponent},
  {path: '**', component: PageNotFoundComponent},
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  /*{ path: 'user', component: BoardUserComponent },
  { path: 'author', component: BoardAuthorComponent },
  { path: 'admin', component: BoardAdminComponent },*/
  {path: '', redirectTo: '/books', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    LogbookAddComponent,
    LogbookListComponent,
    PageNotFoundComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent
   /* BoardAdminComponent,
    BoardAuthorComponent,
    BoardUserComponent,*/
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    NgbModule
  ],
  providers: [LogbookService, authInterceptorProviders, TypeOfClassService],
  bootstrap: [AppComponent]
})
export class AppModule { }
