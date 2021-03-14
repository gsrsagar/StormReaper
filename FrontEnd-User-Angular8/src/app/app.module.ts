import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { SliderModule } from 'angular-image-slider';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { UsersigninComponent } from './usersignin/usersignin.component';
import { UsersignupComponent } from './usersignup/usersignup.component';
import { BookingpageComponent } from './bookingpage/bookingpage.component';
import { UserprofilehomeComponent } from './userprofilehome/userprofilehome.component';
import { RoutedetailstobookComponent } from './routedetailstobook/routedetailstobook.component';
import { ShippageComponent } from './shippage/shippage.component';
import { TicketregistrationComponent } from './ticketregistration/ticketregistration.component';
import { HttpClientModule } from '../../node_modules/@angular/common/http';
import { UserserviceService } from './userservice.service';
import { FormsModule } from '../../node_modules/@angular/forms';
import { BookticketComponent } from './bookticket/bookticket.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { AddpassegerComponent } from './addpasseger/addpasseger.component';


@NgModule({
  declarations: [
    AppComponent,
    UserhomeComponent,
    UsersigninComponent,
    UsersignupComponent,
    BookingpageComponent,
    UserprofilehomeComponent,
    RoutedetailstobookComponent,
    ShippageComponent,
    TicketregistrationComponent,
    BookticketComponent,
    AddpassegerComponent
  ],
  imports: [
    BrowserModule,HttpClientModule,FormsModule,SliderModule,
    AppRoutingModule,
    NoopAnimationsModule
  ],
  providers: [UserserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
