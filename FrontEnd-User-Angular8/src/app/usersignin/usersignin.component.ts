
import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { UserserviceService } from '../userservice.service';
import { User } from '../user';
@Component({
  selector: 'app-usersignin',
  templateUrl: './usersignin.component.html',
   styleUrls: ['./usersignin.component.css']
})
export class UsersigninComponent implements OnInit {

  // model: any = {};
  emailid:string;
  name:string ;
  gender:string;
  presentaddress:string;
  permanentaddress: string ;
  mobileno:number;
  password:string;
  user:User;
 // returnUrl: string;
 // member : Member;
  isLoadingResults = true;
  // email:String;
  // password:String;
  ngOnInit() {
  }
  constructor(private userservice: UserserviceService, private route: ActivatedRoute, private router: Router
  ) {
   }

   login():void {
     this.userservice.login(this.emailid, this.password)
    .subscribe((data: any) => {
       this.user=data;
      if(this.user.password===this.password )
      {
        console.log('admin logged in');
        this.router.navigateByUrl('userhome');

      }
      else{
        this.router.navigateByUrl('usersignin');
      }
    });
    
console.log();
  }
    //  console.log('componenet called');
    // this.member =  this.loginSignupService.login(this.email, this.password);
    // console.log(this.member.firstName);
    // if(this.member.role.role_name === 'admin'){
    //   console.log('admin page');
    //   //this.router.navigateByUrl('/admin');
    // }else{
    //   console.log('ddd');
    // }
   
   

  //   this.loginSignupService.login(this.model.email, this.model.password)
  //     .pipe(first())
  //     .subscribe(
  //       data => {
  //         this.router.navigate([this.returnUrl]);
  //       });
  //  }


  //  public login() {
  //  return this.loginSignupService.login1(this.model.email, this.model.password).subscribe((Response) => {
  //     if (Response['status'] == 'success') {

  //       this.memberArray = Response['data'];
  //       console.log(this.memberArray);
  //     } else {
  //       console.log("Error : " + Response['message']);

  //     }

  //   });
  }


