import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FutureMaman, Gynecologue } from '../models/models';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private base = 'http://localhost:8089/api';

  constructor(private http: HttpClient) {}

  // ── FutureMaman ──────────────────────────────────────
  registerMaman(maman: FutureMaman): Observable<any> {
    return this.http.post(`${this.base}/mamans`, maman);
  }

  getAllMamans(): Observable<FutureMaman[]> {
    return this.http.get<FutureMaman[]>(`${this.base}/mamans`);
  }

  // ── Gynecologue ───────────────────────────────────────
  registerGyneco(gyneco: Gynecologue): Observable<any> {
    return this.http.post(`${this.base}/gynecologues`, gyneco);
  }

  getAllGynecologues(): Observable<Gynecologue[]> {
    return this.http.get<Gynecologue[]>(`${this.base}/gynecologues`);
  }

  // ── Session locale ────────────────────────────────────
  saveUser(user: any, role: 'maman' | 'gyneco'): void {
    localStorage.setItem('user', JSON.stringify(user));
    localStorage.setItem('role', role);
  }

  getUser(): any {
    const u = localStorage.getItem('user');
    return u ? JSON.parse(u) : null;
  }

  getRole(): string {
    return localStorage.getItem('role') || '';
  }

  isMaman(): boolean  { return this.getRole() === 'maman'; }
  isGyneco(): boolean { return this.getRole() === 'gyneco'; }
  isLoggedIn(): boolean { return !!localStorage.getItem('user'); }

  logout(): void {
    localStorage.removeItem('user');
    localStorage.removeItem('role');
  }
}
