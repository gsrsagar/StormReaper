import { Component, OnInit } from '@angular/core';
import { Schedule } from '../schedule';
import{ AdminService} from '../admin.service';
import { Router } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-add-schedule',
  templateUrl: './add-schedule.component.html',
  styleUrls: ['./add-schedule.component.css']
})
export class AddScheduleComponent implements OnInit {
  
  schedule=new Schedule;
  error;
  constructor(private _adminservice: AdminService,private router:Router) { }

  ngOnInit() {
  }
 addSchedule(){
   
 }

  
}
