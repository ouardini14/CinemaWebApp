import { Component, OnInit } from '@angular/core';
import { Cinema } from '../common/cinema';
import { CinemaService } from '../service/cinema.service';
import { CityService } from '../service/city.service';
import { RoomService } from '../service/room.service';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {
  roomName:any;
  cities:any;
  idCity:any;
  idCinema:any;
  cinemas: Cinema[]
  constructor(public cinemaService: CinemaService,
              public cityService: CityService,
              public roomService: RoomService) { }

  ngOnInit(): void {
    this.findAllCities();
  }

  onSaveRoom(formData:any) {
    console.log(formData);

    this.roomService.saveRoom(formData).subscribe(
      data => {
        // this.cities = data;
        alert('Room has been added succeessfully')
        // this.findAllRoomsByCinemaId(cinemaId);
      }, error => {
        console.log(error);
      }
    );
  }


  findAllCities() {
    this.cityService.findAll().subscribe(
      data => {
        this.cities = data;
      }, error => {
        console.log(error);
      }
    );
  }
  onCityChange(event:any) {
    this.idCity = event.target.value;
    this.cinemaService.findCinemasByCityId(this.idCity).subscribe(
      data => {
        this.cinemas = data;
      }, error => {
        console.log(error);
      }
    );
  }

  findAllRoomsByCinemaId(cinemaId:any) {

  }
  onCinemaChange(event:any) {
    console.log(event.target.value);
    this.idCinema = event.target.value;
  }
}
