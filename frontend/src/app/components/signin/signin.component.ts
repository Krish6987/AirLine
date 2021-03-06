import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  form:  FormGroup;
  loading: boolean;
  error: string;
  constructor(private router: Router, private userService: UserService, private cookieService: CookieService) { }

  ngOnInit(): void {
    if(this.cookieService.get("id"))
      this.router.navigate(['/home']);
    this.loading = false;
    this.error = "";
    this.form=new FormGroup({
      id : new FormControl("", Validators.compose([
        Validators.required,
        Validators.pattern('^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$')
      ])),
      password : new FormControl("",  Validators.compose([
        Validators.required,
        Validators.minLength(6)
      ]))
    })
  }

  signin(data: any) {
    this.loading = true;
    this.userService.signin(data).subscribe((res) =>{
      if(res == "true"){
        this.cookieService.set('id', data.id)
        this.loading = false;
        this.router.navigate(['/home']);
      }
      else if(res == "false"){
        this.error="incorrect"
        this.loading = false;
      }
      else{
        this.error="invalid"
        this.loading = false;
      }
    });


  }

}