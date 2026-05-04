import { bootstrapApplication } from '@angular/platform-browser';
import { provideRouter } from '@angular/router';
import { provideHttpClient } from '@angular/common/http';
import { importProvidersFrom } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app/components/app/app.component';
import { LandingComponent } from './app/components/landing/landing.component';
import { LoginComponent } from './app/components/login/login.component';
import { RegisterComponent } from './app/components/register/register.component';
import { HomeComponent } from './app/components/home/home.component';
import { ContractionsComponent } from './app/components/contractions/contractions.component';
import { BirthPlanComponent } from './app/components/birth-plan/birth-plan.component';
import { HospitalBagComponent } from './app/components/hospital-bag/hospital-bag.component';
import { CommunauteMamanComponent } from './app/components/communaute-maman/communaute-maman.component';
import { CommunauteGynecoComponent } from './app/components/communaute-gyneco/communaute-gyneco.component';

bootstrapApplication(AppComponent, {
  providers: [
    provideHttpClient(),
    importProvidersFrom(FormsModule),
    provideRouter([
      { path: '',                  component: LandingComponent },
      { path: 'login',             component: LoginComponent },
      { path: 'register',          component: RegisterComponent },
      { path: 'home',              component: HomeComponent },
      { path: 'contractions',      component: ContractionsComponent },
      { path: 'birth-plan',        component: BirthPlanComponent },
      { path: 'hospital-bag',      component: HospitalBagComponent },
      { path: 'communaute-maman',  component: CommunauteMamanComponent },
      { path: 'communaute-gyneco', component: CommunauteGynecoComponent },
      { path: '**',                redirectTo: '' }
    ])
  ]
}).catch(err => console.error(err));
