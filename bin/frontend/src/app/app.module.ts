import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing/app-routing.module';

import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { HeaderComponent } from './components/header/header.component';
import { SignupComponent } from './components/signup/signup.component';
import { SigninComponent } from './components/signin/signin.component';

import { CookieService } from 'ngx-cookie-service';
import { UserService } from './services/user.service';
import { LogoutComponent } from './components/logout/logout.component';
import { FooterComponent } from './components/footer/footer.component';
import { SearchflightsComponent } from './components/searchflights/searchflights.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    SignupComponent,
    SigninComponent,
    LogoutComponent,
    FooterComponent,
    SearchflightsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [
    CookieService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
