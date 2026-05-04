import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ApiService } from '../../services/api.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-contractions',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './contractions.component.html',
  styleUrls: ['./contractions.component.css']
})
export class ContractionsComponent implements OnInit, OnDestroy {
  isRunning = false;
  elapsed = 0;
  startTime: Date | null = null;
  intervalRef: any = null;
  contractions: any[] = [];
  alertMsg = '';
  showHospitalAlert = false;
  mamanId: number;

  constructor(private api: ApiService, private auth: AuthService) {
    const u = this.auth.getUser();
    this.mamanId = u?.id || 0;
  }

  ngOnInit() { this.loadContractions();
    this.checkAlert();
   }

  loadContractions() {
    if (!this.mamanId) return;
    this.api.getContractions(this.mamanId).subscribe({
      next: (d) => { this.contractions = d.sort((a, b) => 
      new Date(b.debut as string).getTime() - new Date(a.debut as string).getTime()
      );
        this.checkAlertLocal(); },
      error: () => {}
    });
  }

  start() {
    this.isRunning = true;
    this.elapsed = 0;
    this.startTime = new Date();
    this.intervalRef = setInterval(() => this.elapsed++, 1000);
  }

  stop() {
    this.isRunning = false;
    clearInterval(this.intervalRef);
    if (!this.startTime) return;

    const fin = new Date();
    this.api.addContraction({
      debut: this.startTime.toISOString(),
      fin: fin.toISOString(),
      dureeSecondes: this.elapsed,
      maman: { id: this.mamanId }
    }).subscribe({
      next: () => this.loadContractions(),
      error: () => {}
    });

    this.elapsed = 0;
    this.startTime = null;
  }

checkAlertLocal() {
  if (this.contractions.length < 3) return;

  const last3 = this.contractions.slice(0, 3);

  const intervals = [];
  for (let i = 0; i < last3.length - 1; i++) {
    const t1 = new Date(last3[i].debut).getTime();
    const t2 = new Date(last3[i + 1].debut).getTime();
    intervals.push((t1 - t2) / 60000);
  }

  const avgInterval = intervals.reduce((a, b) => a + b, 0) / intervals.length;

  const longEnough = last3.every(c => c.dureeSecondes >= 30);

  this.showHospitalAlert = avgInterval <= 5 && longEnough;
}

  checkAlert() {
    if (!this.mamanId) return;
    this.api.getAlert(this.mamanId).subscribe({
      next: (m) => { this.alertMsg = m; this.showHospitalAlert = m.toLowerCase().includes('allez'); },
      error: () => {}
    });
  }

  get avgDuration(): number {
    if (!this.contractions.length) return 0;
    const total = this.contractions.reduce((sum, c) => sum + c.dureeSecondes, 0);
    return Math.round(total / this.contractions.length);
  }

  get lastInterval(): string {
    if (this.contractions.length < 2) return '--';
    const last = new Date(this.contractions[0].debut);
    const prev = new Date(this.contractions[1].debut);
    return Math.round((last.getTime() - prev.getTime()) / 60000) + ' min';
  }

  formatTime(s: number) {
    const m = Math.floor(s / 60);
    return `${m}:${(s % 60).toString().padStart(2, '0')}`;
  }

  formatHeure(iso?: string) {
    if (!iso) return '';
    return new Date(iso).toLocaleTimeString('fr-FR', { hour: '2-digit', minute: '2-digit' });
  }

  ngOnDestroy() { clearInterval(this.intervalRef); }
}
