import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  role: 'maman' | 'gyneco' = 'maman';
  nomComplet = '';
  email = '';
  motDePasse = '';
  dateAccouchement = '';
  moisGrossesse = 1;
  loading = false;
  error = '';
  success = false;

  constructor(private auth: AuthService, public router: Router) {}

  register() {
    if (!this.nomComplet || !this.email || !this.motDePasse) {
      this.error = 'Veuillez remplir tous les champs.';
      return;
    }
    this.loading = true;
    this.error = '';

    if (this.role === 'maman') {
      this.auth.registerMaman({
        nomComplet: this.nomComplet,
        email: this.email,
        motDePasse: this.motDePasse,
        dateAccouchementPrevue: this.dateAccouchement,
        moisGrossesse: this.moisGrossesse
      }).subscribe({
        next: () => { this.success = true; this.loading = false; },
        error: () => { this.error = "Erreur lors de l'inscription."; this.loading = false; }
      });
    } else {
      this.auth.registerGyneco({
        nomComplet: this.nomComplet,
        email: this.email,
        motDePasse: this.motDePasse
      }).subscribe({
        next: () => { this.success = true; this.loading = false; },
        error: () => { this.error = "Erreur lors de l'inscription."; this.loading = false; }
      });
    }
  }
}
