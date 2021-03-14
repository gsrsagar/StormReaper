import { Schedule } from './schedule';
import { Route } from './route';

export class Ship {


    shipid: number;
    shipname: String;
    source: String;
    destination: String;
    travelduration: String;
    seatingcapacity: String;
    reservationcapacityregular:String;
    reservationcapacityworkload:String;
    schedule:Schedule;
    route:Route;

}
