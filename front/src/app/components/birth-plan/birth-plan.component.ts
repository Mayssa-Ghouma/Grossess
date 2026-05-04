import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-birth-plan',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './birth-plan.component.html',
  styleUrls: ['./birth-plan.component.css']
})
export class BirthPlanComponent implements OnInit {
  saved = false;
  birthPlanId: number | null = null;
  mamanId: number;

  prefs = [
    { key: 'peridurale',   label: 'Péridurale',          desc: 'Analgésie',                    value: null as boolean | null },
    { key: 'respiration',  label: 'Respiration',          desc: 'Techniques',                   value: null as boolean | null },
    { key: 'papa',         label: 'Partenaire présent',   desc: 'Présence du partenaire',        value: null as boolean | null },
    { key: 'massage',      label: 'Massage',              desc: 'Massage pendant travail',       value: null as boolean | null },
    { key: 'lumDouce',     label: 'Lumière tamisée',      desc: 'Ambiance calme',               value: null as boolean | null },
    { key: 'ballon',       label: 'Ballon',               desc: 'Ballon de naissance',           value: null as boolean | null },
    { key: 'douche',       label: 'Douche',               desc: "Accouchement dans l'eau",       value: null as boolean | null },
    { key: 'allaitement',  label: 'Allaitement',          desc: 'Dans la première heure',        value: null as boolean | null },
    { key: 'peauPeau',     label: 'Peau à peau',          desc: 'Contact immédiat',              value: null as boolean | null },
    { key: 'biberon',      label: 'Biberon',              desc: 'Si nécessaire',                 value: null as boolean | null }
  ];

  constructor(private api: ApiService, private auth: AuthService) {
    const u = this.auth.getUser();
    this.mamanId = u.id;
  }

  ngOnInit() {
    this.api.getBirthPlan(this.mamanId).subscribe({
      next: (bp) => {
        if (bp && bp.id) {
          this.birthPlanId = bp.id;
          this.prefs.forEach(p => { p.value = (bp as any)[p.key] ?? null; });
        }
      }
    });
  }

  getSelected() { return this.prefs.filter(p => p.value !== null).length; }

  save() {
    const bp: any = { maman: { id: this.mamanId } };
    this.prefs.forEach(p => { bp[p.key] = p.value ?? false; });

    const request$ = this.birthPlanId
      ? this.api.updateBirthPlan(this.birthPlanId, bp)
      : this.api.saveBirthPlan(bp);

    request$.subscribe({
      next: (res) => {
        this.birthPlanId = res.id || null;
        this.saved = true;
        setTimeout(() => this.saved = false, 3000);
      },
      error: (err) => { console.error('Erreur API', err); }
    });
  }
}
