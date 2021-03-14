import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersigninComponent } from './usersignin/usersignin.component';
import { UsersignupComponent } from './usersignup/usersignup.component';
import { AppComponent } from './app.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { BookingpageComponent } from './bookingpage/bookingpage.component';
import { AddpassegerComponent } from './addpasseger/addpasseger.component';


const routes: Routes = [{path:`usersignin`,component:UsersigninComponent},
{path:`usersignup`,component:UsersignupComponent},
{path:`home`, component:AppComponent},
{path:`userhome`, component:UserhomeComponent,children:
[
 
  {path:`addpassenger`,component:AddpassegerComponent,children:
  [
    {path:`bookticket`,component:BookingpageComponent}
  ]
}
]}, 
{path:`bookticket`,component:BookingpageComponent}                       
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
