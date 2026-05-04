import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ApiService } from '../../services/api.service';
import { AuthService } from '../../services/auth.service';
import { Post } from '../../models/models';

@Component({
  selector: 'app-communaute-gyneco',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './communaute-gyneco.component.html',
  styleUrls: ['./communaute-gyneco.component.css']
})
export class CommunauteGynecoComponent implements OnInit {
  tab = 'posts';
  showPostForm = false;
  filter: 'tous' | 'GENERAL' | 'CONSEIL' = 'tous';
  posts: Post[] = [];
  questions: any[] = [];
  replyingTo: number | undefined = undefined;
  replyText = '';
  newPost: { titre: string; contenu: string; type: 'GENERAL' | 'CONSEIL' } = {
    titre: '', contenu: '', type: 'GENERAL'
  };
  gynecoId: number;
  gynecoName: string;

  constructor(private api: ApiService, private auth: AuthService) {
    const u = this.auth.getUser();
    this.gynecoId   = u.id ;
    this.gynecoName = u.nomComplet;
  }

  ngOnInit() { this.loadPosts(); }

  loadPosts() {
    this.api.getAllPosts().subscribe({
      next: (d) => { this.posts = d; },
      error: () => {}
    });
  }

  loadAllQuestions() {
    this.auth.getAllMamans().subscribe({
      next: (mamans) => {
        this.questions = [];
        mamans.forEach(m => {
          if (!m.id) return;
          this.api.getQuestionsByMaman(m.id).subscribe({
            next: (qs) => {
              qs.forEach(q => {
                const wm = { ...q, futureMaman: { id: m.id!, nomComplet: m.nomComplet }, commentaires: [] };
                if (q.id) {
                  this.api.getCommentaireByQuestion(q.id).subscribe({
                    next: (cs: any) => this.questions.push({ ...wm, commentaires: Array.isArray(cs) ? cs : [cs] }),
                    error: () => this.questions.push(wm)
                  });
                } else {
                  this.questions.push(wm);
                }
              });
            },
            error: () => {}
          });
        });
      },
      error: () => {}
    });
  }

  filteredPosts() {
    return this.filter === 'tous' ? this.posts : this.posts.filter(p => p.type === this.filter);
  }

  publishPost() {
    if (!this.newPost.titre || !this.newPost.contenu) return;
    this.api.createPost({
      titre: this.newPost.titre,
      contenu: this.newPost.contenu,
      type: this.newPost.type,
      gynecologue: { id: this.gynecoId, nomComplet: this.gynecoName }
    }).subscribe({
      next: () => {
        this.newPost = { titre: '', contenu: '', type: 'GENERAL' };
        this.showPostForm = false;
        this.loadPosts();
      },
      error: () => {}
    });
  }

  submitReply(q: any) {
    if (!this.replyText.trim() || !q.id) return;
    const payload = {
      commentaire: this.replyText,
      dateCommentaire: new Date().toISOString(),
      gynecologue: { id: this.gynecoId },
      question: { id: q.id }
    };
    this.api.addCommentaire(payload).subscribe({
      next: (c: any) => {
        const idx = this.questions.findIndex(x => x.id === q.id);
        if (idx >= 0) {
          const newComment = { ...c, gynecologue: { id: this.gynecoId, nomComplet: this.gynecoName } };
          this.questions = this.questions.map((item, i) =>
            i === idx ? { ...item, commentaires: [...(item.commentaires || []), newComment] } : item
          );
        }
        this.replyingTo = undefined;
        this.replyText = '';
      },
      error: (err: any) => { console.error('Erreur commentaire', err); }
    });
  }

  formatDate(iso?: string) {
    if (!iso) return '';
    return new Date(iso).toLocaleDateString('fr-FR', {
      day: 'numeric', month: 'long', hour: '2-digit', minute: '2-digit'
    });
  }
}
