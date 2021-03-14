import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';
import { ActivatedRoute, Router } from '../../../node_modules/@angular/router';
import { User } from '../user';

@Component({
  selector: 'app-usersignup',
  templateUrl: './usersignup.component.html',
  styleUrls: ['./usersignup.component.css']
})
export class UsersignupComponent {
  
user:User;
emailid:string;
    name:string ;
    gender:string;
    presentaddress:string;
    permanentaddress: string ;
    mobileno:number;
    password:string;
  constructor(private userserv :UserserviceService,private route: ActivatedRoute, private router:Router) { }
 
  


addUser(): void {
  
  console.log('called');
  this.user={ 
    'emailid': this.emailid,
    'name':this.name,
    'gender': this.gender,
  'presentaddress': this.presentaddress,
   'permanentaddress': this.permanentaddress,
   'mobileno':this.mobileno,
   'password': this.password
                     };
   

this.userserv.adduser(this.user);
console.log("failed");
this.router.navigateByUrl('usersignin');
}

}
// {
//   "emailid": "Sagarreddyguvvala1@gmail.com",
//   "name": "sagar",
//   "gender": "m",
//   "presentaddress": "Nellore",
//   "permanentaddress": "Nellore",
//   "mobileno": 9494744282,
//   "password": "Sagarr123"
// }
// import { Component, OnInit } from '@angular/core';
 
// import {Router} from "@angular/router";
// import {ApiService} from "../../service/api.service";

// @Component({
//   selector: 'app-add-user',
//   templateUrl: './add-user.component.html',
//   styleUrls: ['./add-user.component.css']
// })
// export class AddUserComponent implements OnInit {

//   constructor(private formBuilder: FormBuilder,private router: Router, private apiService: ApiService) { }

//   addForm: FormGroup;

  // ngOnInit() {
  //   this.addForm = this.formBuilder.group({
  //     id: [],
  //     username: ['', Validators.required],
  //     password: ['', Validators.required],
  //     firstName: ['', Validators.required],
  //     lastName: ['', Validators.required],
  //     age: ['', Validators.required],
  //     salary: ['', Validators.required]
  //   });

  // }

  // onSubmit() {
  //   this.userserv.adduser(this.addForm.value)
  //     .subscribe( data => {
  //       this.router.navigate(['usersignin']);
  //     });
  // }

