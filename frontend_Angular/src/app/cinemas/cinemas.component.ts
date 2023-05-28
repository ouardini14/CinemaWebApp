import { Component, OnInit } from '@angular/core';
import { CinemasService } from '../service/cinemas.service';

@Component({
  selector: 'app-cinema',
  templateUrl: './cinemas.component.html',
  styleUrls: ['./cinemas.component.css']
})
export class CinemasComponent implements OnInit {

  cities:any;
  cinemas:any;
  rooms:any;
  currentCity:any;
  currentCinema:any;
  currentProjection:any;
  selectedTickets: any[];
  constructor(public cinemasService: CinemasService) { }

  ngOnInit(): void {
    this.cinemasService.getAllCities().subscribe(
      (data) => {
        this.cities = data;
      }, (error) => {
        console.log(error);
      }
    );
  }
  onGetCinemas(city:any) {
    this.currentCity = city.name;
    this.rooms = undefined;
    this.cinemasService.getCinemas(city).subscribe(
      (data) => {
        this.cinemas = data;
        console.log(this.cities);

      }, (error) => {
        console.log(error);
      }
    );
  }
  onGetRooms(cinema:any) {
    this.currentCinema = cinema;
    this.cinemasService.getRooms(cinema).subscribe(
      (data) => {
        this.rooms = data;
        this.rooms._embedded.rooms.forEach((room:any) => {
          this.cinemasService.getProjections(room).subscribe(
            (data) => {
              room.projections = data;
            }, (error) => {
              console.log(error);
            }
          );
        });

      }, (error) => {
        console.log(error);
      }
    );
  }
  onGetTicketsPlaces(p:any) {
    this.currentProjection = p;
    this.cinemasService.getTicketsPlaces(p).subscribe(
      (data) => {
        this.currentProjection.tickets = data;
        this.selectedTickets = [];
      }, (error) => {
        console.log(error);
      }
    );
  }
  onGetMovieDetails(room:any) {
    console.log('Im here!!');
    console.log(room);
  }
  onSelectTicket(t:any) {
    t.selected = !t.selected;
    if (t.selected) {
      this.selectedTickets.push(t);
    }
    else {
      this.selectedTickets.splice(this.selectedTickets.indexOf(t), 1);
    }

    console.log(this.selectedTickets);
  }
  getTicketClass(t:any) {
    let className = 'btn ';

    if (t.reserve) {
      className += 'btn-danger';
    }
    else if (t.selected) {
      className += 'btn-warning';
 }
    else {
      className += 'btn-light';
 }

    return className;
  }

  onPayTickets(f:any) {
    const tickets:any[] = [];
    this.selectedTickets.forEach(ticket => {
      tickets.push(ticket.id);
    });
    f.tickets = tickets;
    this.cinemasService.buyTickets(f).subscribe(
      (data) => {
        alert('Réservation effectué');
        this.onGetTicketsPlaces(this.currentProjection);
      }, error => {

      }
    );

  }
  getRandom():number{
    return  Math.floor(Math.random() * 3) + 1
  }
}
