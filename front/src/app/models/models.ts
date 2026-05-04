// ===================== USERS =====================
export interface FutureMaman {
  id?: number;
  nomComplet: string;
  email: string;
  motDePasse: string;
  dateAccouchementPrevue?: string;
  moisGrossesse?: number;
  emailVerifie?: boolean;
}

export interface Gynecologue {
  id?: number;
  nomComplet: string;
  email: string;
  motDePasse: string;
  emailVerifie?: boolean;
}

// ===================== CONTRACTION =====================
export interface Contraction {
  id?: number;
  debut?: string;
  fin?: string;
  dureeSecondes?: number;
  maman?: { id: number };
}

// ===================== BIRTH PLAN =====================
export interface BirthPlan {
  id?: number;
  peridurale: boolean;
  respiration: boolean;
  papa: boolean;
  massage: boolean;
  lumDouce: boolean;
  ballon: boolean;
  douche: boolean;
  allaitement: boolean;
  peau_peau: boolean;
  biberon: boolean;
  maman?: { id: number };
}

// ===================== BAG MAMAN =====================
export interface BagMaman {
  id?: number;
  brosse: boolean;
  carte: boolean;
  chaussettes: boolean;
  dossier: boolean;
  deodorant: boolean;
  serviette: boolean;
  soutiens: boolean;
  tenueSortie: boolean;
  telephone: boolean;
  pyjama: boolean;
  maman?: { id: number };
}

// ===================== BAG BABY =====================
export interface BagBaby {
  id?: number;
  biberon: boolean;
  bonnet: boolean;
  carnetSante: boolean;
  chaussettes: boolean;
  couches: boolean;
  couverture: boolean;
  lingettes: boolean;
  pyjamas: boolean;
  serviette: boolean;
  tenueSortie: boolean;
  maman?: { id: number };
}

// ===================== BAG PAPA =====================
export interface BagPapa {
  id?: number;
  argent: boolean;
  carte: boolean;
  eau: boolean;
  trousse: boolean;
  telephone: boolean;
  maman?: { id: number };
}

// ===================== POST =====================
export interface Post {
  id?: number;
  titre: string;
  contenu: string;
  type: 'GENERAL' | 'CONSEIL';
  datePublication?: string;
  gynecologue?: { id: number; nomComplet?: string };
  auteurNom?: string;
  likes?: number;
}

// ===================== QUESTION MAMAN =====================
export interface QuestionMaman {
  id?: number;
  question: string;
  dateQuestion?: string;
  futureMaman?: { id: number; nomComplet?: string };
  commentaire?: CommentaireGyneco[];
}

// ===================== COMMENTAIRE GYNECO =====================
export interface CommentaireGyneco {
  id?: number;
  commentaire: string;
  dateCommentaire?: string;
  gynecologue?: { id: number; nomComplet?: string };
  questionMaman?: { id: number };
}
