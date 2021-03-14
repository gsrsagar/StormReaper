import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,HttpErrorResponse} from '@angular/common/http';
import { Schedule } from './schedule';
import {  of, throwError } from 'rxjs';
import { catchError, tap, map } from 'rxjs/operators';
import { User } from './user';
import { Passenger } from './passenger';
import { Ticket } from './ticket';
import { Route } from '../../node_modules/@angular/compiler/src/core';
import { Ship } from './ship';
import {BehaviorSubject,Observable } from 'rxjs';
import { parse } from 'querystring';



const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {
   url='http://localhost:8089/StormReaper';
   private currentUserSubject :  BehaviorSubject<User>;
   public currentUser : Observable<User>;
  private currentPassenger:BehaviorSubject<Passenger>;
  public currentpass:Observable<Passenger>;
  private currentShip:BehaviorSubject<Ship[]>;
  public currentShips:Observable<Ship[]>
  private currentTicket:BehaviorSubject<Ticket>;
  public currentticket:Observable<Ticket>;

   constructor(private _http:HttpClient) {
    this.currentUserSubject=new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser')));
    this.currentUser=this.currentUserSubject.asObservable();
    this.currentPassenger=new BehaviorSubject<Passenger>(JSON.parse(localStorage.getItem('currentPassenger')));
    this.currentpass=this.currentPassenger.asObservable();
    this.currentShip=new BehaviorSubject<Ship[]>(JSON.parse(localStorage.getItem('currentship')));
    this.currentShips=this.currentShip.asObservable();
    this.currentTicket=new BehaviorSubject<Ticket>(JSON.parse(localStorage.getItem('currentticket')));
    this.currentticket=this.currentTicket.asObservable();
  }
  public get currentUserValue():User{
        return this.currentUserSubject.value;
      }

  public get CurrentPassenger():Passenger{
    return this.currentPassenger.value;
  }    
 public get CurrentShips():Ship[]{
   return this.currentShip.value;
 }

 public get CurrentTicket():Ticket{
   return this.currentTicket.value;
 }

adduser(user: User): Observable<any> {
    console.log("servicee called");
    const apiUrl=`http://localhost:8089/StormReaper/user/adduser`;
  return this._http.post(apiUrl, user, httpOptions).pipe(
     tap(_ => console.log(`add user emailid=${user.emailid}`)),
     catchError(this.handleError<User>(`add user`))
  );
}



//   getTicketById(ticketno: String): Observable<Ticket> {
//     const apiUrl='http://localhost:8089/StormReaper/user/getticketbyid/${ticketno}';
//    const url = `${apiUrl}/${ticketno}`;
//    return this._http.get<Ticket>(url).pipe(
//      tap(_ => console.log(`fetched 
//      ticketno=${ticketno}`)),
//      catchError(this.handleError<Ticket>(`getdriver ticketno=${ticketno}`))
//    );
//  }
 
//  getRouteById(routeid: String): Observable<Route> {
//   const apiUrl='http://localhost:8089/StormReaper/user/getroutebyid/${routeid}';
//  const url = `${apiUrl}/${routeid}`;
//  return this._http.get<Route>(url).pipe(
//    tap(_ => console.log(`fetched 
//    routeid=${routeid}`)),
//    catchError(this.handleError<Route>(`getroute routeid=${routeid}`))
//  );
// }


// getShipById(shipid: string): Observable<Ship> {
//   const apiUrl='http://localhost:8089/StormReaper/user/getshipbyid/${shipid}';
//  const url = `${apiUrl}/${shipid}`;
//  return this._http.get<Ship>(url).pipe(
//    tap(_ => console.log(`fetched 
//    shipid=${shipid}`)),
//    catchError(this.handleError<Ship>(`getship shipid=${shipid}`))
//  );
// }

// getShipByName( shipname: string): Observable<any> {
//   const apiUrl='http://localhost:8089/StormReaper/user/getshipbyid/${shipid}';
//   const url = `${apiUrl}/${shipname}`;
//   return this._http.get<Ship>(url).pipe(
//     tap(_ => console.log(`fetched 
//     shipname=${shipname}`)),
//     catchError(this.handleError<Ship>(`getship shipid=${shipname}`))
//   );
//  }
 
 getAllShips(): Observable<Ship[]>{
  const apiUrl='http://localhost:8089/StormReaper/user/getallships';
  const url=`${apiUrl}`;
  return this._http.get<Ship[]>(url).pipe(
    tap(_ => console.log(`all Ships`)),
  catchError(this.handleError<Ship[]>(`cannot display `))
  );
  }

//   ViewReservedTicket(passenger_id:string): Observable<Ticket[]>{
//     const apiUrl='http://localhost:8089/StormReaper/user/viewreservedticket/{passenger_id}';
//     const url=`${apiUrl}/${passenger_id}`;
//     return this._http.get<Ticket[]>(url).pipe(
//       tap(_ => console.log(`fetched 
//       passenger_id=${passenger_id}`)),
//     catchError(this.handleError<Ticket[]>(`cannot display `))
//     );
//   }

//   getShipByScheduleId(scheduleid:number): Observable<Ship>{
//     const apiUrl='http://localhost:8089/StormReaper/user/getshipbyscheduleid/${scheduleid}';
//     const url=`${apiUrl}/${scheduleid}`;
//     return this._http.get<Ship>(url).pipe(
//       tap(_ => console.log(`fetched 
//       scheduleid=${scheduleid}`)),
//     catchError(this.handleError<Ship>(`cannot display `))
//     );
//   }

  BookTicket(ticket:Ticket): Observable<any>{
  const apiUrl=`http://localhost:8089/StormReaper/user/bookticket`;
  console.log("ticket service called");
  console.log(ticket);
 return this._http.post(apiUrl,Ticket,httpOptions).pipe(
tap(_=> console.log(`add Ticket ticketno=${ticket.ticketno}`)),
catchError(this.handleError<Ticket>(`book ticket`)))
}

getallroutes(): Observable<Route[]>{
  const apiUrl='http://localhost:8089/StormReaper/user/getallroutes';
  const url=`${apiUrl}`;
  return this._http.get<Route[]>(url).pipe(
    tap(_ => console.log(`all routes`)),
  catchError(this.handleError<Route[]>(`cannot display `))
  );
  }

  getAllSchedules(): Observable<Schedule[]> {
    const apiUrl='http://localhost:8089/StormReaper/user/getallschedules';
    const url=`${apiUrl}`;
  return this._http.get<Schedule[]>(url).pipe(
    tap(_ => console.log(`all routes`)),
  catchError(this.handleError<Schedule[]>(`cannot display `))
  );
  
}

private handleError<T> (operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {

    // TODO: send the error to remote logging infrastructure
    console.error(error); // log to console instead

    // Let the app keep running by returning an empty result.
    return of(result as T);
  };
}

 getshipbyrouteid(routeid:number):Observable<Ship[]>{
      const apiUrl='http://localhost:8089/StormReaper/user/getshipbyrouteid/{routeid}';
      console.log("service called");
      const url=`${apiUrl}`;
      return this._http.get<Ship[]>(url)
     .pipe(tap(ship => {
        localStorage.setItem('currentShip',JSON.stringify(ship));
       this.currentShip.next(ship);
     return ship;}),
       catchError(this.handleError<Ship[]>(`getShip`))
     );
    
 }

 getticketbymobileno(mobileno:number):Observable<Ticket>{
   const apiUrl='http://localhost:8089/StormReaper/user/getticketbymobileno/{mobileno}';
   console.log("service called");
   const url=`${apiUrl}`;
   return this._http.get<Ticket>(url)
   .pipe(tap(ticket =>{
     localStorage.setItem('currentticket',JSON.stringify(ticket));
     this.currentTicket.next(ticket);
     return ticket;}),
     catchError(this.handleError<Ticket>(`getTicket`))
    );
  
 }



addpassenger(passenger: Passenger) :Observable<Passenger>{
  const apiUrl='http://localhost:8089/StormReaper/user/addpassenger';
  const url1= `${apiUrl}`;
console.log("service called");
console.log('pasenger details '+ passenger);
 //return this._http.post('http://localhost:8089/StormReaper/user/addpassenger', JSON.stringify(passenger));
//console.log('pasenger details '+ passenger);
return this._http.post<Passenger>(url1, passenger, httpOptions).pipe(tap(data => {
  localStorage.setItem('currentPassenger',JSON.stringify(data));
  this.currentPassenger.next(data);
return data;}),
catchError(this.handleError<Passenger>(`passenger cant be added`))
);

}

login(email: string, password: string):Observable<User>{
  console.log('service called');  
  const url1= 'http://localhost:8089/StormReaper/user/userlogin';

 const lurl=`${url1}/${email}/${password}`;
  return this._http.get<User>(lurl)
  .pipe(tap(user => {
    localStorage.setItem('currentPassenger',JSON.stringify(user));
    this.currentUserSubject.next(user);
  return user;}),
  catchError(this.handleError<User>(`getProduct id=${email}`))
);

} 

logout(){
  localStorage.removeItem('currentUser');
  this.currentUserSubject.next(null);
  this.currentPassenger.next(null);
  this.currentTicket.next(null);
}

}



