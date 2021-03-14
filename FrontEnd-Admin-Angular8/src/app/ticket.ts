import { Passenger } from './passenger';
import { Schedule } from './schedule';

export class Ticket {
   
    ticketno: String;
    passenger: Passenger;
    seat_no: number;
        paymenttype:String;
        journeydate:String;
        ticketcost:number;
        schedule:Schedule;

}
