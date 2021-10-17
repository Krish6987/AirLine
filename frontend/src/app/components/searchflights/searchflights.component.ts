import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-searchflights',
  templateUrl: './searchflights.component.html',
  styleUrls: ['./searchflights.component.css']
})
export class SearchflightsComponent implements OnInit {

  form:  FormGroup;
  loading: boolean;
  error: string;
  data: any;
  flights: any;
  cityList = ["Bengaluru", "Chennai", "Delhi", "Goa", "Leh", "Mumbai", "Srinagar"]
  descities: Array<any>;
  depcities: Array<any>;
  message: string

  constructor(private router: Router, private userService: UserService, private cookieService: CookieService) { }

  ngOnInit(): void {
    if(!this.cookieService.get("id"))
      this.router.navigate(['/signin']);
    this.loading = false;
    this.message = ''
    this.flights = ''
    this.depcities = this.cityList
    this.descities = this.cityList
    this.form=new FormGroup({
      departurecity : new FormControl("", Validators.compose([
        Validators.required
      ])),
      destinationcity : new FormControl("",  Validators.compose([
        Validators.required
      ])),
      date : new FormControl("",  Validators.compose([
        Validators.required
      ])),
      seats : new FormControl("",  Validators.compose([
        Validators.required
      ])),
      class : new FormControl("",  Validators.compose([
        Validators.required
      ])),
    })
  }

  changeDesCityList(){
    // var temp = this.cityList
    // const index = temp.indexOf(this.form.get("departurecity")?.value)
    // temp.splice(index,1)
    // this.descities = temp
  }

  changeDepCityList(){
    // var temp = this.cityList
    // const index = temp.indexOf(this.form.get("destinationcity")?.value)

    // temp.splice(index,1)
    // this.depcities = temp
  }

  searchFlights(data: any){
    this.loading = true;
    this.message = ''
    this.flights = ''
    this.data = {
      departure: data.departurecity,
      destination: data.destinationcity,
      date: data.date,
      type: data.class,
      seats: data.seats
    }
    this.userService.getFlights(this.data).subscribe((res) =>{
      this.loading = false;
      if(Object.keys(res).length !== 0){
        this.flights = res
      }
      else {
        this.message = "No Flights found with the search";
      }
    });
  }

}
