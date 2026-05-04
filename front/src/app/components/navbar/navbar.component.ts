import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  isMaman = false;
  isGyneco = false;

  constructor(private auth: AuthService, private router: Router) {}

  ngOnInit() {
    this.isMaman = this.auth.isMaman();
    this.isGyneco = this.auth.isGyneco();
  }

  goHome() {
    this.router.navigate([this.isMaman ? '/home' : '/communaute-gyneco']);
  }

  logout() {
    this.auth.logout();
    this.router.navigate(['/']);
  }
}
