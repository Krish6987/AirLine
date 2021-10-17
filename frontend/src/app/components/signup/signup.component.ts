import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, Validators, FormControl, AbstractControl, ValidationErrors } from '@angular/forms';
import { CookieService } from 'ngx-cookie-service';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {

  form: FormGroup;
  user: any;
  id: any;
  loading: boolean;
  error: boolean;

  constructor(private router: Router, private userService: UserService, private cookieService: CookieService) {}

  ngOnInit(): void {
    if(this.cookieService.check("id"))
      this.router.navigate(['/home']);
    this.loading = false;
    this.error = false;

    this.form = new FormGroup(
      {
        firstname: new FormControl(
          '',
          Validators.compose([
            Validators.required,
            Validators.minLength(3),
            Validators.pattern('[a-zA-Z ]*'),
          ])
        ),
        lastname: new FormControl(
          '',
          Validators.compose([
            Validators.required,
            Validators.minLength(3),
            Validators.pattern('[a-zA-Z ]*'),
          ])
        ),
        email: new FormControl(
          '',
          Validators.compose([
            Validators.required,
            Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,5}$'),
          ])
        ),
        mobile: new FormControl(
          '',
          Validators.compose([
            Validators.required,
            Validators.pattern('^((\\+91-?)|0)?[0-9]{10}$'),
          ])
        ),
        password: new FormControl(
          '',
          Validators.compose([
            Validators.required,
            Validators.pattern(
              '(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-zd$@$!%*?&].{6,}'
            ),
          ])
        ),
        confirmpassword: new FormControl('', [Validators.required]),
        address: new FormControl('', [Validators.required]),
      },
      { validators: this.matchingPasswords}
    );
  }

  matchingPasswords(c: AbstractControl): ValidationErrors | null {
    let password = c.get(['password']);
    let confirmPassword = c.get(['confirmpassword']);

    if (password === confirmPassword) {
      return { mismatch: true };
    }
    return null;
  }

  signup(data: any) {
    this.loading = true;
    this.id = String(data.email).split("@",1)
    this.user = {
      id: this.id[0],
      firstName: data.firstname,
      lastName: data.lastname,
      email: data.email,
      password: data.password,
      telephone: String(data.mobile),
      address: data.address
    }
    this.userService.addUser(this.user).subscribe((res) =>{
      this.loading = false;
      if(res == "true"){
        alert("Your User Id is :: "+ this.id[0]+"\nUse this while signing in")
        this.router.navigate(['/signin']);
      }
      else if(res == "false"){
        this.error = true;
      }
    });

  }
}