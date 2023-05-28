import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CinemaComponent } from './cinema/cinema.component';
import { NavbarComponent } from './navbar/navbar.component';

import { from } from 'rxjs';
import { CityComponent } from './ville/city.component';
import { CinemasComponent } from './cinemas/cinemas.component';
import { RoomComponent } from './salle/room.component';
import { CinemaDetailComponent } from './cinema-detail/cinema-detail.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    CinemaComponent,
    NavbarComponent,
    CityComponent,
    CinemasComponent,
    RoomComponent,
    CinemaDetailComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
