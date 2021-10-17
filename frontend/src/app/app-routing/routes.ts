import { Routes } from '@angular/router';


import { HomeComponent } from '../components/home/home.component';
import { SigninComponent } from '../components/signin/signin.component';
import { SignupComponent } from '../components/signup/signup.component';
import { LogoutComponent } from '../components/logout/logout.component';
import { SearchflightsComponent } from '../components/searchflights/searchflights.component';
import { BookflightComponent } from '../components/bookflight/bookflight.component';
import { BookingsComponent } from '../components/bookings/bookings.component';

export const routes: Routes = [
    { path: '',  component: HomeComponent },
    { path: 'signin',  component: SigninComponent },
    { path: 'signup',  component: SignupComponent },
    { path: 'logout',  component: LogoutComponent },
    { path: 'searchflights',  component: SearchflightsComponent },
    { path: 'bookings',  component: BookingsComponent },
    { path: 'bookflight/:id', component: BookflightComponent },
    { path: 'home', redirectTo: '/', pathMatch: 'full'}
];