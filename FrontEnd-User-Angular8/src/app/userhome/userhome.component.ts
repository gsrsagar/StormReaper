import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { User } from '../user';
import { Router, ActivatedRoute } from '@angular/router';
import { Ticket } from '../ticket';

@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {
currentuser:User
tickets:Ticket;
showProfileDetails :boolean=false;
  constructor(private Userserv:UserserviceService, private router:Router) {
    this.currentuser = this.Userserv.currentUserValue;
   // this.tickets=this.Userserv.getticketbymobileno(this.currentuser.mobileno);
   }
 
   home()
   {
    this.router.navigateByUrl('home');
   }
   toggledetails():void
   {
      this.showProfileDetails= !this.showProfileDetails;
   }


  ngOnInit() {


  }

}
