import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { ActivatedRoute, Router } from '../../../node_modules/@angular/router';
import { Ship } from '../ship';
import { Passenger } from '../passenger';
import { Route } from '../route';
@Component({
  selector: 'app-addpasseger',
  templateUrl: './addpasseger.component.html',
  styleUrls: ['./addpasseger.component.css']
})
export class AddpassegerComponent implements OnInit {

  //passenger :Passenger;
  ships: Ship[];
  // pname:string;
  // age: number;
  // gender:string;
  // bookingdate:string;
  ship: Ship;
  shipid: number;
  routes: any;
  shipss: Ship[];
  routeid: number;
  //contactno:number;
  pass:Passenger;
  pid: string = " sf";
  passenger = new Passenger();
  constructor(private userserviceService: UserserviceService, private route1: ActivatedRoute, private router: Router) {
  }



  ngOnInit() {
    this.userserviceService.getAllShips()
      .subscribe(data => { this.ships = data; });

    this.userserviceService.getallroutes()
      .subscribe(data => { this.routes = data; });
  }

  selectschedule(routeid) {
    this.userserviceService.getshipbyrouteid(routeid)
      .subscribe(data => { this.shipss = data });
    console.log(routeid);

    this.shipss = this.userserviceService.CurrentShips;
  }




  addPassenger(): void {

    this.passenger = {
      'pid': this.pid,
      'pname': this.passenger.pname,
      'age': this.passenger.age,
      'gender': this.passenger.gender,
      'bookingdate': 'd',
      'contactno': this.passenger.contactno,
      'ship': {
        'shipid': this.shipid,
        'shipname': ' ',
        'source': '',
        'destination': ' ',
        'travelduration': ' ',
        'seatingcapacity': 250,
        'reservationcapacityregular': 248,
        'reservationcapacityworkload': 250,
        'schedule': {
          'scheduleid': 1,
          'arrivaldetails': ' ',
          'departuredetails': ' ',
        },
        'route': {
          'routeid': this.routeid,
          'source': 'banglore',
          'destination': 'Chennai',
          'distance': 300,
          'duration': '6 hrs',
          'costperkm': 120,
        }
      }
    };
    console.log(this.passenger);
    this.userserviceService.addpassenger(this.passenger).subscribe((res: any) => {
      const id = res._id;
      this.router.navigateByUrl('bookticket');
    }, (err: any) => {
      console.log(err);
    });


  }





}








