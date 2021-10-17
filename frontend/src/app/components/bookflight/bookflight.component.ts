import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-bookflight',
  templateUrl: './bookflight.component.html',
  styleUrls: ['./bookflight.component.css']
})
export class BookflightComponent implements OnInit {

  flightNumber: any
  userId: string
  user: any
  flight: any
  form: FormGroup
  bookForm: FormGroup
  total: number
  showDetails: boolean
  confirmationNumber: String
  constructor(private activatedroute:ActivatedRoute, private router: Router, private userService: UserService, private cookieService: CookieService) { }

  ngOnInit(): void {
    this.confirmationNumber = ""
    this.flight = {}
    if(!this.cookieService.check("id"))
      this.router.navigate(['/signin']);
    this.activatedroute.paramMap.subscribe(params => { 
      this.flightNumber = params.get('id'); 
    });
    this.userId = this.cookieService.get("id")
    this.userService.getUser(this.userId).subscribe((res) =>{
      if(res == null){
        this.router.navigate(['/signin'])
      }
      else {
        this.user = res
      }
    });
    this.userService.getFlightDetails(this.flightNumber).subscribe((res) =>{
      if(res == null){
        this.router.navigate(['/signin'])
      }
      else {
        this.flight = res
      }
    });
    this.form=new FormGroup({
      class : new FormControl("", Validators.compose([
        Validators.required
      ])),
      seats : new FormControl("",  Validators.compose([
        Validators.required
      ]))
    })
    this.bookForm=new FormGroup({
      name : new FormControl("", Validators.compose([
        Validators.required
      ])),
      address : new FormControl("",  Validators.compose([
        Validators.required
      ])),
      ccNumber : new FormControl("",  Validators.compose([
        Validators.required,
        Validators.pattern('^[0-9]{16}$')
      ]))
    })
    this.showDetails = false
  }
  
  calculateTotal(){
    this.showDetails = false
    if (this.form.get("class")?.value == "" && this.form.get("seats")?.value<= 0){
      this.total = 0
    }
    else{
      let price = 0
      if (this.form.get("class")?.value == "business")
        price = this.flight.businessClassPrice
      else if (this.form.get("class")?.value == "economy")
        price = this.flight.economyClassPrice
      this.total = this.form.get("seats")?.value * price
    }
  }
  
  enterDetails(){
    if(this.total > 0){
      this.showDetails = true
    }
    else{
      this.showDetails = false
    }
  }

  book(data: any){
    if(confirm("Are you sure want to proceed Booking?")){
      let details = {
        flight_number: this.flightNumber,
        type: this.form.get("class")?.value,
        seats: this.form.get("seats")?.value,
        id: this.userId,
        passengerName: data.name,
        address: data.address,
        creditCard: data.ccNumber,
        totalCost: this.total
      }

      this.userService.bookFlight(details).subscribe((res) =>{
        if(res == "Booking Unsuccessful"){
          this.confirmationNumber = "wrong"
        }
        else{
          this.confirmationNumber = res
        }
      });
    }
  }

}
