import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';
import {
  Contraction, BirthPlan, BagMaman, BagBaby, BagPapa,
  Post, QuestionMaman, CommentaireGyneco
} from '../models/models';

@Injectable({ providedIn: 'root' })
export class ApiService {
  private base = 'http://localhost:8089/api/mamans';

  constructor(private http: HttpClient) {}

  // ── CONTRACTIONS ─────────────────────────────────────
  addContraction(c: Contraction): Observable<Contraction> {
    return this.http.post<Contraction>(`${this.base}/contraction`, c);
  }
  getContractions(mamanId: number): Observable<Contraction[]> {
    return this.http.get<Contraction[]>(`${this.base}/contraction/${mamanId}`);
  }
  getAlert(mamanId: number): Observable<string> {
    return this.http.get(`${this.base}/contraction/alert/${mamanId}`, { responseType: 'text' });
  }

  // ── BIRTH PLAN ────────────────────────────────────────
  saveBirthPlan(bp: any): Observable<any> {
    return this.http.post<any>(`${this.base}/birthplan`, bp);
  }
  updateBirthPlan(id: number, bp: any): Observable<any> {
    return this.http.put<any>(`${this.base}/birthplan/${id}`, bp);
  }
  getBirthPlan(mamanId: number): Observable<any> {
    return this.http.get<any>(`${this.base}/birthplan/${mamanId}`).pipe(
      catchError(() => of(null))
    );
  }

  // ── BAG MAMAN ─────────────────────────────────────────
  saveBagMaman(b: BagMaman): Observable<BagMaman> {
    return this.http.post<BagMaman>(`${this.base}/bagmaman`, b);
  }
  getBagMaman(mamanId: number): Observable<BagMaman> {
    return this.http.get<BagMaman>(`${this.base}/bagmaman/${mamanId}`);
  }
  updateBagMaman(id: number, b: BagMaman): Observable<BagMaman> {
    return this.http.put<BagMaman>(`${this.base}/bagmaman/${id}`, b);
  }

  // ── BAG BABY ──────────────────────────────────────────
  saveBagBaby(b: BagBaby): Observable<BagBaby> {
    return this.http.post<BagBaby>(`${this.base}/bagbaby`, b);
  }
  getBagBaby(mamanId: number): Observable<BagBaby> {
    return this.http.get<BagBaby>(`${this.base}/bagbaby/${mamanId}`);
  }
  updateBagBaby(id: number, b: BagBaby): Observable<BagBaby> {
    return this.http.put<BagBaby>(`${this.base}/bagbaby/${id}`, b);
  }

  // ── BAG PAPA ──────────────────────────────────────────
  saveBagPapa(b: BagPapa): Observable<BagPapa> {
    return this.http.post<BagPapa>(`${this.base}/bagpapa`, b);
  }
  getBagPapa(mamanId: number): Observable<BagPapa> {
    return this.http.get<BagPapa>(`${this.base}/bagpapa/${mamanId}`);
  }
  updateBagPapa(id: number, b: BagPapa): Observable<BagPapa> {
    return this.http.put<BagPapa>(`${this.base}/bagpapa/${id}`, b);
  }

  // ── POSTS ─────────────────────────────────────────────
  createPost(p: Post): Observable<Post> {
    return this.http.post<Post>(`${this.base}/post`, p);
  }
  getAllPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(`${this.base}/post`);
  }
  getPostsByType(type: 'GENERAL' | 'CONSEIL'): Observable<Post[]> {
    return this.http.get<Post[]>(`${this.base}/post/${type}`);
  }

  // ── QUESTIONS MAMAN ───────────────────────────────────
  createQuestion(q: any): Observable<any> {
    return this.http.post<any>(`${this.base}/question`, q);
  }
  getQuestionsByMaman(mamanId: number): Observable<QuestionMaman[]> {
    return this.http.get<QuestionMaman[]>(`${this.base}/question/maman/${mamanId}`);
  }

  // ── COMMENTAIRES GYNECO ───────────────────────────────
  addCommentaire(c: CommentaireGyneco): Observable<CommentaireGyneco> {
    return this.http.post<CommentaireGyneco>(`${this.base}/question/commentaire`, c);
  }
  getCommentaireByQuestion(questionId: number): Observable<any[]> {
    return this.http.get<any[]>(`${this.base}/question/commentaire/${questionId}`);
  }
}
