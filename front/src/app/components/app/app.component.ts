import { Component } from '@angular/core';
import { Router, NavigationEnd, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from '../navbar/navbar.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, NavbarComponent],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  showNavbar = false;

  constructor(private router: Router) {
    this.router.events.subscribe(e => {
      if (e instanceof NavigationEnd) {
        const publicRoutes = ['/', '/login', '/register'];
        this.showNavbar = !publicRoutes.includes(e.urlAfterRedirects);
      }
    });
  }
}
