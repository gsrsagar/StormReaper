import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule} from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SliderModule } from 'angular-image-slider';
import {RouterModule ,Routes } from '@angular/router';
import {HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { ViewRouteComponent } from './view-route/view-route.component';
import { AddRouteComponent } from './add-route/add-route.component';
import { EditRouteComponent } from './edit-route/edit-route.component';
import { ViewScheduleComponent } from './view-schedule/view-schedule.component';
import { EditScheduleComponent } from './edit-schedule/edit-schedule.component';
import { AddScheduleComponent } from './add-schedule/add-schedule.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { AddShipComponent } from './add-ship/add-ship.component';
import { EditShipComponent } from './edit-ship/edit-ship.component';
import { ViewShipComponent } from './view-ship/view-ship.component';
import { ViewBookingInfoComponent } from './view-booking-info/view-booking-info.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';



const appRoutes: Routes =[ 
  {path:'adminsignin',component:AdminLoginComponent},
  
   ];
  









@NgModule({
  declarations: [
    AppComponent,
    ViewRouteComponent,
    AddRouteComponent,
    EditRouteComponent,
    ViewScheduleComponent,
    EditScheduleComponent,
    AddScheduleComponent,
    AdminHomeComponent,
    AddShipComponent,
    EditShipComponent,
    ViewShipComponent,
    ViewBookingInfoComponent,
    AdminLoginComponent
  ],
  imports: [
    BrowserModule,FormsModule ,RouterModule.forRoot(appRoutes),
     BrowserAnimationsModule ,SliderModule,HttpClientModule,ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
