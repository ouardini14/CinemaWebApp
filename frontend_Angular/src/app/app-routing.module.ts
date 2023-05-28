import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CinemaDetailComponent } from './cinema-detail/cinema-detail.component';
import { CinemaComponent } from './cinema/cinema.component';
import { CinemasComponent } from './cinemas/cinemas.component';
import { LoginComponent } from './login/login.component';
import { RoomComponent } from './salle/room.component';
import { CityComponent } from './ville/city.component';

const routes: Routes = [
  {path: 'admin/cinema', component: CinemaComponent  },
  {path: 'admin/cinema-detail/:id/:cityId', component: CinemaDetailComponent  },
  {path: 'admin/city', component: CityComponent  },
  {path: 'admin/room', component: RoomComponent  },

  {path: 'cinemas', component: CinemasComponent  },
  {path: 'login', component: LoginComponent},


  {path: '', redirectTo: 'cinemas', pathMatch: 'full'}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
