import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  currentWeek = 24;
  weeksLeft = 16;
  prenom = 'Mama';
  babySize = 'Maïs';
  babyEmoji = '🌽';
  dueDate = '';

  private babySizeMap: { [k: number]: [string, string] } = {
    8:  ['Framboise', '🫐'],
    12: ['Citron',    '🍋'],
    16: ['Avocat',    '🥑'],
    20: ['Banane',    '🍌'],
    24: ['Maïs',      '🌽'],
    28: ['Aubergine', '🍆'],
    32: ['Noix de coco', '🥥'],
    36: ['Ananas',    '🍍'],
    40: ['Pastèque',  '🍉']
  };

  constructor(private auth: AuthService, public router: Router) {}

  ngOnInit() {
    const user = this.auth.getUser();
    if (!user) { this.router.navigate(['/login']); return; }

    this.prenom = user.nomComplet?.split(' ')[0] || 'Mama';

    if (user.moisGrossesse) {
      this.currentWeek = user.moisGrossesse * 4;
    }

    if (user.dateAccouchementPrevue) {
      const due = new Date(user.dateAccouchementPrevue);
      this.weeksLeft = Math.max(0, Math.round(
        (due.getTime() - new Date().getTime()) / (7 * 24 * 60 * 60 * 1000)
      ));
      this.dueDate = due.toLocaleDateString('fr-FR', {
        day: 'numeric', month: 'long', year: 'numeric'
      });
    }

    const closest = Object.keys(this.babySizeMap)
      .map(Number)
      .reduce((a, b) =>
        Math.abs(b - this.currentWeek) < Math.abs(a - this.currentWeek) ? b : a
      );
    [this.babySize, this.babyEmoji] = this.babySizeMap[closest];
  }
}
