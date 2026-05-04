import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-communaute-maman',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './communaute-maman.component.html',
  styleUrls: ['./communaute-maman.component.css']
})
export class CommunauteMamanComponent implements OnInit {
  tab = 'posts';
  showQForm = false;
  newQuestion = '';
  posts: any[] = [];
  questions: any[] = [];
  pf: 'tous' | 'GENERAL' | 'CONSEIL' = 'tous';
  mamanId: number;

  constructor(private api: ApiService, private auth: AuthService) {
    const u = this.auth.getUser();
    this.mamanId = u?.id || 0;
  }

  ngOnInit() {
    this.loadPosts();
    this.loadQuestions();
  }

  loadPosts() {
    this.api.getAllPosts().subscribe({
      next: (d) => { this.posts = d.map(p => ({ ...p })); },
      error: () => {}
    });
  }

  loadQuestions() {
    if (!this.mamanId) return;
    this.api.getQuestionsByMaman(this.mamanId).subscribe({
      next: (qs) => {
        this.questions = qs.map(q => ({ ...q, commentaires: [] }));
        qs.forEach((q, i) => {
          if (q.id) {
            this.api.getCommentaireByQuestion(q.id).subscribe({
              next: (cs: any) => {
                const liste = Array.isArray(cs) ? cs : [cs];
                this.questions = this.questions.map((item, idx) =>
                  idx === i ? { ...item, commentaires: liste } : item
                );
              },
              error: () => {}
            });
          }
        });
      },
      error: (err) => { console.error('Erreur =', err); }
    });
  }

  filteredPosts() {
    return this.pf === 'tous' ? this.posts : this.posts.filter((p: any) => p.type === this.pf);
  }

  submitQuestion() {
    if (!this.newQuestion.trim()) return;
    const payload = {
      question: this.newQuestion,
      dateQuestion: new Date().toISOString(),
      maman: { id: this.mamanId }
    };
    this.api.createQuestion(payload).subscribe({
      next: () => {
        this.newQuestion = '';
        this.showQForm = false;
        this.tab = 'questions';
        this.loadQuestions();
      },
      error: (err) => { console.error('Erreur création question =', err); }
    });
  }

  formatDate(iso?: string) {
    if (!iso) return '';
    return new Date(iso).toLocaleDateString('fr-FR', {
      day: 'numeric', month: 'long', hour: '2-digit', minute: '2-digit'
    });
  }
}
