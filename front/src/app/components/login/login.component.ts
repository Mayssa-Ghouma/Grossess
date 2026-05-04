import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  role: 'maman' | 'gyneco' = 'maman';
  email = '';
  password = '';
  loading = false;
  error = '';

  constructor(private auth: AuthService, public router: Router) {}

  login() {
    if (!this.email || !this.password) {
      this.error = 'Veuillez remplir tous les champs.';
      return;
    }
    this.loading = true;
    this.error = '';
    const obs$ = this.role === 'maman' ? this.auth.getAllMamans() : this.auth.getAllGynecologues();
    obs$.subscribe({
      next: (users: any[]) => {
        const user = users.find((u: any) => u.email === this.email && u.motDePasse === this.password);
        if (user) {
          this.auth.saveUser(user, this.role);
          this.router.navigate([this.role === 'maman' ? '/home' : '/communaute-gyneco']);
        } else {
          this.error = 'Email ou mot de passe incorrect.';
          this.loading = false;
        }
      },
      error: () => {
        this.error = 'Erreur de connexion au serveur.';
        this.loading = false;
      }
    });
  }
}
