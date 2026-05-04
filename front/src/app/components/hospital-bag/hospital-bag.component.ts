import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-hospital-bag',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './hospital-bag.component.html',
  styleUrls: ['./hospital-bag.component.css']
})
export class HospitalBagComponent implements OnInit {
  tab = 'maman';
  saved = false;
  mamanId: number;

  bagMamanId: number | null = null;
  bagBabyId:  number | null = null;
  bagPapaId:  number | null = null;

  mamanItems = [
    { key: 'brosse',       label: 'Brosse à cheveux',              v: false },
    { key: 'carte',        label: 'Carte vitale & documents',       v: false },
    { key: 'chaussettes',  label: 'Chaussettes',                   v: false },
    { key: 'dossier',      label: 'Dossier médical',                v: false },
    { key: 'deodorant',    label: 'Déodorant',                     v: false },
    { key: 'serviette',    label: 'Serviette de toilette',          v: false },
    { key: 'soutiens',     label: "Soutien-gorge d'allaitement",    v: false },
    { key: 'tenueSortie',  label: 'Tenue de sortie',                v: false },
    { key: 'telephone',    label: 'Téléphone + chargeur',           v: false },
    { key: 'pyjama',       label: 'Pyjama (2-3)',                   v: false }
  ];

  babyItems = [
    { key: 'biberon',      label: 'Biberon',                        v: false },
    { key: 'bonnet',       label: 'Bonnet bébé',                    v: false },
    { key: 'carnetSante',  label: 'Carnet de santé',                v: false },
    { key: 'chaussettes',  label: 'Chaussettes bébé',               v: false },
    { key: 'couches',      label: 'Couches (taille naissance)',      v: false },
    { key: 'couverture',   label: 'Couverture',                     v: false },
    { key: 'lingettes',    label: 'Lingettes bébé',                 v: false },
    { key: 'pyjamas',      label: 'Pyjamas bébé (3)',               v: false },
    { key: 'serviette',    label: 'Serviette bébé',                 v: false },
    { key: 'tenueSortie',  label: 'Tenue de sortie bébé',           v: false }
  ];

  papaItems = [
    { key: 'argent',    label: 'Argent liquide',       v: false },
    { key: 'carte',     label: 'Carte bancaire',        v: false },
    { key: 'eau',       label: "Bouteille d'eau",       v: false },
    { key: 'trousse',   label: 'Trousse de toilette',   v: false },
    { key: 'telephone', label: 'Téléphone + chargeur',  v: false }
  ];

  constructor(private api: ApiService, private auth: AuthService) {
    const u = this.auth.getUser();
    this.mamanId = u?.id ?? u?.idMaman ?? u?.maman_id ?? 0;
  }

  ngOnInit() {
    this.api.getBagMaman(this.mamanId).subscribe({
      next: (b) => { if (b) { this.bagMamanId = b.id || null; this.mamanItems.forEach(i => { i.v = (b as any)[i.key] ?? false; }); }},
      error: () => {}
    });
    this.api.getBagBaby(this.mamanId).subscribe({
      next: (b) => { if (b) { this.bagBabyId = b.id || null; this.babyItems.forEach(i => { i.v = (b as any)[i.key] ?? false; }); }},
      error: () => {}
    });
    this.api.getBagPapa(this.mamanId).subscribe({
      next: (b) => { if (b) { this.bagPapaId = b.id || null; this.papaItems.forEach(i => { i.v = (b as any)[i.key] ?? false; }); }},
      error: () => {}
    });
  }

  getCurrentItems() {
    return this.tab === 'maman' ? this.mamanItems : this.tab === 'baby' ? this.babyItems : this.papaItems;
  }

  getTabPacked()   { return this.getCurrentItems().filter(i => i.v).length; }
  getTabItems()    { return this.getCurrentItems().length; }
  getTotalPacked() { return [...this.mamanItems, ...this.babyItems, ...this.papaItems].filter(i => i.v).length; }
  getTotalItems()  { return this.mamanItems.length + this.babyItems.length + this.papaItems.length; }

  save() {
    const mamanRef = { id: this.mamanId };

    const bm: any = { maman: mamanRef };
    this.mamanItems.forEach(i => bm[i.key] = i.v);
    (this.bagMamanId ? this.api.updateBagMaman(this.bagMamanId, bm) : this.api.saveBagMaman(bm))
      .subscribe({ next: (r) => { this.bagMamanId = r.id || null; }, error: (e) => console.error(e) });

    const bb: any = { maman: mamanRef };
    this.babyItems.forEach(i => bb[i.key] = i.v);
    (this.bagBabyId ? this.api.updateBagBaby(this.bagBabyId, bb) : this.api.saveBagBaby(bb))
      .subscribe({ next: (r) => { this.bagBabyId = r.id || null; }, error: (e) => console.error(e) });

    const bp: any = { maman: mamanRef };
    this.papaItems.forEach(i => bp[i.key] = i.v);
    (this.bagPapaId ? this.api.updateBagPapa(this.bagPapaId, bp) : this.api.saveBagPapa(bp))
      .subscribe({
        next: (r) => { this.bagPapaId = r.id || null; this.saved = true; setTimeout(() => this.saved = false, 3000); },
        error: (e) => console.error(e)
      });
  }
}
