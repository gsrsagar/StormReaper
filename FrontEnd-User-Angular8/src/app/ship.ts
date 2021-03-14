import { Schedule } from './schedule';
import{Route} from './route';

export class Ship {

    shipid: number;
    shipname: string;
    source: string;
    destination: string;
    travelduration: string;
    seatingcapacity: number;
    reservationcapacityregular:number;
    reservationcapacityworkload:number;
    schedule:Schedule;
    route:Route;

}
