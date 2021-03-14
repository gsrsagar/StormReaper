import { Schedule } from './schedule';
import { Passenger } from './passenger';

export class Ticket {
    ticketno: string;
    passenger: Passenger;
    seat_no: number;
        paymenttype:string;
        journeydate:string;
        ticketcost:number;
        schedule:Schedule;
}
