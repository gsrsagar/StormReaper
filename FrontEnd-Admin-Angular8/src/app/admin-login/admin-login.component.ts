import { Component, OnInit } from '@angular/core';
import { Router } from '../../../node_modules/@angular/router';
import{ AdminService} from '../admin.service';
import { Admin } from '../admin';
import { ReturnStatement } from '../../../node_modules/@angular/compiler';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent implements OnInit {
 admin =new Admin();
 error;
  constructor(private _adminservice: AdminService,private router:Router ) {

   }
  
  ngOnInit() {
  }

//  adminLogin(admin1: Admin):boolean{
//   console.log('called');
//   this.admin1={ 'aid':this.admin1.aid,
//                     'adminname':this.admin1.adminname,
//                     'adminpassword':this.1.adminpassword                    
// };


// this._adminservice.adminLogin(this.admin1);
// return this.adminLogin

// }
}
