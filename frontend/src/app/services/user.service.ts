import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public url = environment.apiUrl;

  constructor(private http: HttpClient) { }

  signin(data: {email: String, password: String}){
    return this.http.post(this.url+"/signin", data, {responseType: 'text'});
  }

  addUser(user: {id: String, firstName: String, lastName: String, email: String, password: String, telephone: String, address: String}){
    return this.http.post(this.url+"/signup", user, {responseType: 'text'});
  }

  getFlights(data: {departure: String, destination: String, date: String, type: String, seats: String}){
    return this.http.post(this.url+"/getflights", data, {responseType: 'json'});
  }

  getUser(userId: String){
    return this.http.get(this.url+"/getuser/"+userId);
  }

  getFlightDetails(flightNumber: String){
    return this.http.get(this.url+"/getflightdetails/"+flightNumber);
  }

  bookFlight(details: any){
    return this.http.post(this.url+"/bookflight", details, {responseType: 'text'});
  }

  getBookings(userId: String){
    return this.http.get(this.url+"/getbookings/"+userId);
  }
}
