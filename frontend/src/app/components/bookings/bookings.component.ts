import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-bookings',
  templateUrl: './bookings.component.html',
  styleUrls: ['./bookings.component.css']
})
export class BookingsComponent implements OnInit {

  userId: string;
  user: any;
  bookings: any;
  message: boolean;
  constructor(private router: Router, private userService: UserService, private cookieService: CookieService) { }

  ngOnInit(): void {
    this.message = false;
    if(!this.cookieService.check("id"))
      this.router.navigate(['/signin']);
    this.userId = this.cookieService.get("id")
    this.userService.getUser(this.userId).subscribe((res) =>{
      if(res == null){
        this.router.navigate(['/signin'])
      }
      else {
        this.user = res
      }
    });

    this.userService.getBookings(this.userId).subscribe((res) =>{
      if(Object.keys(res).length == 0){
        this.message = false
      }
      else {
        this.message = true
        this.bookings = res
      }
    });
    
  }

}
