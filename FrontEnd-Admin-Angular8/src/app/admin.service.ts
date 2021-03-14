 import { Injectable } from '@angular/core';
 import {HttpClientModule } from '@angular/common/http';
 import { HttpClient, HttpHeaders } from '@angular/common/http';
 import { Admin } from './admin';
import { Schedule } from './schedule';
import { AddScheduleComponent } from './add-schedule/add-schedule.component';



 @Injectable()
  export class AdminService {
   private http: HttpClient;
   private headers= new HttpHeaders({'Content-Type':'application/json'});
   constructor(_http: HttpClient)
       {     this.http = _http;
        
  }
  


 private handleError(error: any ): Promise<any>{
   console.error('Error', error);
   return Promise.reject(error.message || error);
 }

 addAdmin(admin: Admin): Promise<Admin>{
  return this.http.post(`http://localhost:8089/StormReaper/admin/addadmin`,
  JSON.stringify(admin),{headers: this.headers}).
toPromise().then(res => res.json() as Admin).catch(this.handleError);


// addSchedule(schedule: Schedule): Promise<Schedule>{
//   return this.http.post(`http://localhost:8089/StormReaper/admin/addschedule`,
//   JSON.stringify(schedule),{headers: this.headers}).
// toPromise().then(res => res.json() as Schedule).catch(this.handleError);



// import { Injectable } from '@angular/core';
// import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
// import { Driver } from './driver';
// import { Observable, of, throwError } from 'rxjs';
// import { catchError, tap, map } from 'rxjs/operators';

// const httpOptions = {
//   headers: new HttpHeaders({'Content-Type': 'application/json'})
// };

// @Injectable()
// export class DriverService {

//   //private http: HttpClientModule;
  
// constructor(private _http:HttpClient) {
  
//  }

getById(id: String): Observable<Driver> {
   const apiUrl='http://localhost:8087/SpringRest/drivers/drivergetById';
  const url = `${apiUrl}/${id}`;
  return this._http.get<Driver>(url).pipe(
    tap(_ => console.log(`fetched 
     id=${id}`)),
    catchError(this.handleError<Driver>(`getdriver id=${id}`))
  );
}

updateDriver(driver: Driver): Observable<any> {
  const apiUrl='http://localhost:8087/SpringRest/drivers/driverupdate';
return this._http.put(apiUrl, driver, httpOptions).pipe(
   tap(_ => console.log(`update driver id=${driver.did}`)),
   catchError(this.handleError<Driver>(`update driver`))
);
}

addDriver(driver: Driver): Observable<any> {
  const apiUrl='http://localhost:8087/SpringRest/drivers/driveradd';
return this._http.post(apiUrl, driver, httpOptions).pipe(
   tap(_ => console.log(`add driver id=${driver.did}`)),
   catchError(this.handleError<Driver>(`update driver`))
);
}
deleteDriver(id: String): Observable<any>{
  const apiUrl='http://localhost:8087/SpringRest/drivers/driverdelete';
  const url = `${apiUrl}/${id}`;
return this._http.delete(url).pipe(
   tap(_ => console.log(`add driver id=${id}`)),
   catchError(this.handleError<Driver>(`update driver`))
);
}

// signUp(driver:Driver): Promise<void>{
// return this._http.post('http://localhost:8087/SpringRest/drivers/driveradd'
// ,JSON.stringify(driver)
// ,{headers: this.headers})

// .toPromise()
// .then(res => res.json() as Driver)
// .catch(this.handleError);
// }

// login(driver:Driver): Promise<Driver>{
// return this._http.get('http://localhost:8087/SpringRest/drivers/driverlogin/{did}/{pass}'
//   ,{headers: this.headers})
//   .toPromise()
//   .then(res => res.json() as Driver)
//   .catch(this.handleError);
// }

// updateDriver(driver:Driver): Promise<void>{
// return this._http.put('http://localhost:8087/SpringRest/drivers/driverupdate'
// ,JSON.stringify(driver)
// ,{headers: this.headers})
// .toPromise()
// .then(res => res.json() as Driver)
// .catch(this.handleError);
// }











private handleError<T> (operation = 'operation', result?: T) {
  return (error: any): Observable<T> => {

    // TODO: send the error to remote logging infrastructure
    console.error(error); // log to console instead

    // Let the app keep running by returning an empty result.
    return of(result as T);
  };
}

}













}































// adminLogin(email:string,password:string): Promise<boolean>{
//  const url=
//   return this.http.get(`http://localhost:8089/StormReaper/admin/adminlogin`,
//     JSON.stringify(Admin),{headers: this.headers}).
//   toPromise().then(res => res.json()  as Admin).catch(this.handleError);
//   }

// adminLogin(aid:number, adminpassword:String): Promise<boolean> {
//   return this.http.get(`http://localhost:8089/StormReaper/admin/adminlogin/${aid}/${adminpassword}`,
//   JSON.stringify({aid,adminpassword}))
  
//   .toPromise()
  
//   .then(response => { 
   
//   const Admin =response.json() && response.json().Admin;
  
//   console.log(response.text());
  
//   if(response.text()==='true'){
  
//   return false;
  
//   }else{
  
//   return true;
  
//   }
  
//   })
  
//   .catch(this.handleError);
  
  
  
//   }
  

}