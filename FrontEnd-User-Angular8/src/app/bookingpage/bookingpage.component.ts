import { Component, ViewEncapsulation, OnInit  } from '@angular/core';
import { UserserviceService } from '../userservice.service';
//import { Router } from '../../../node_modules/@angular/router';
import { Schedule } from '../schedule';
import { Router, ActivatedRoute } from '@angular/router';
import { Ship } from '../ship';
import { Route } from '../route';
import { Passenger } from '../passenger';
import { User } from '../user';
import { Ticket } from '../ticket';



@Component({
  selector: 'app-bookingpage',
  templateUrl: './bookingpage.component.html',
  styleUrls: ['./bookingpage.component.css'],
  encapsulation:ViewEncapsulation.None
})
export class BookingpageComponent  implements OnInit  {
  //displayedcolumns: string[]=['scheduleid','arrivaldetails','departuredetails'];
 // schedules: Schedule[];

 schedules:any;
 arrivaldetails:string;
 departuredetails:string;
 scheduleid:number;
 schedule:Schedule;
 ship:Ship;
 ships:Ship[];
 routes:any;
 route:Route;
 routeid:number;
 pid:string;
 seatno:number;
 ticketcost:number=2500;
 passenger:Passenger;
 currentpassenger:Passenger;
 patmenttype:string;
 currentuser1:User;
 ticket:Ticket;
 contactno:number;

  isLoadingResults = true;
  constructor(private userserv :UserserviceService ,private route1: ActivatedRoute, private router: Router,)
   {  this.getallschedules();
      
       this.currentuser1=userserv.currentUserValue;
       this.currentpassenger=this.userserv.CurrentPassenger;
    }
  
    getallschedules()
    {this.userserv.getAllSchedules()
      .subscribe(data =>{ this.schedules=data;});
     
   
    }

    // getAllRoutes()
    // {
    //   this.userserv.getallroutes().subscribe(data =>{this.routes=data;});
    // }
    selectarrival()
    {
      alert(this.scheduleid);
       this.schedule.scheduleid=this.scheduleid;
      
          // this.userserv.get(this.scheduleid)
          // .subscribe(data=>{this.ship=data;});
          
          
          
     }
     ngOnInit() {
      this.userserv.getAllShips()
      .subscribe(data =>{ this.ships=data;});

      this.userserv.getallroutes()
      .subscribe(data =>{this.routes=data;});
     
        
    }
  
    addTicket(): void {
      this.ticket={
        'ticketno': "12",
        'passenger': {
            'pid': "100003",
            'pname': "sagar",
            'age': 22,
            'gender': "m",
            'bookingdate': "2019-08-15 12:08:33",
            'contactno': 9494744282,
            'ship': {
                'shipid': 1,
                'shipname': "Titanic",
                'source': "Vishakapatnam",
                'destination': "nellore",
                'travelduration': "14 hrs",
                'seatingcapacity': 200,
                'reservationcapacityregular': 250,
                'reservationcapacityworkload': 250,
                'schedule': {
                    'scheduleid': 1,
                    'arrivaldetails': "TUE, 19/09/2019",
                    'departuredetails': "WED,20/09/2019"
                },
                'route': {
                    'routeid': 1,
                    'source': "Visakhapatnam",
                    'destination': "Nellore",
                    'distance': 600,
                    'duration': "14 hrs",
                    'costperkm': 40
                }
            }
        },
        'seat_no': 1,
        'paymenttype': "Debit",
        'journeydate': "30/09/2019",
        'schedule': {
            'scheduleid': 1,
            'arrivaldetails': "TUE, 19/09/2019",
            'departuredetails': "WED,20/09/2019"
        },
        "ticketcost": 2500
    }
                          this.userserv.addpassenger(this.passenger);
  this.router.navigateByUrl('userhome');
  
                        }
    





















    }

  
    // selectdeparture()
    // {
    //   alert(this.departuredetails);
    // }

  

    //this.router.navigateByUrl('bookticket');}

//   ngOnInit() {
//      //.userserv.getAllSchedules().subscribe(schedule=>this.schedules=schedule);
//    // this.studentService.getStudents().then(students =>this.students=students);
//  // this.getallschedules();
//  this.userserv.getAllSchedules()
//    .subscribe((data: any) => {
//      this.schedules = data;
//      console.log(this.schedules);
//      this.isLoadingResults = false;
//      });
    




  // getallschedules():any {
  //   this.userserv.getAllSchedules()
  //  .subscribe((data: any) => {
  //    this.schedules = data;
  //    console.log(this.schedules);
  //    this.isLoadingResults = false;
  //    });
  //  }

