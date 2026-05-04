package com.grosses.projet.service.interfaces;
import java.util.List;

import com.grosses.projet.entity.Gynecologue;
public interface GynecologueService {
    Gynecologue createGynecologue(Gynecologue gynecologue);
    List<Gynecologue> getAllGynecologues();

}
