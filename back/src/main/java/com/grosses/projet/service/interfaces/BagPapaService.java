package com.grosses.projet.service.interfaces;
import com.grosses.projet.entity.BagPapa;

public interface BagPapaService {
    BagPapa saveBagPapa(BagPapa bagPapa);
    BagPapa getBagPapaByMaman(Long idMaman);
    BagPapa updateBagPapa(Long id, BagPapa bagPapa);

}
