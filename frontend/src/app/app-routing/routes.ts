import { Routes } from '@angular/router';


import { HomeComponent } from '../components/home/home.component';
import { SigninComponent } from '../components/signin/signin.component';
import { SignupComponent } from '../components/signup/signup.component';
import { LogoutComponent } from '../components/logout/logout.component';
import { SearchflightsComponent } from '../components/searchflights/searchflights.component';

export const routes: Routes = [
    { path: '',  component: HomeComponent },
    { path: 'signin',  component: SigninComponent },
    { path: 'signup',  component: SignupComponent },
    { path: 'logout',  component: LogoutComponent },
    { path: 'searchflights',  component: SearchflightsComponent },
    { path: 'home', redirectTo: '/', pathMatch: 'full'}
];