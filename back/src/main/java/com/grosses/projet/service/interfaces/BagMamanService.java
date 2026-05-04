package com.grosses.projet.service.interfaces;

import com.grosses.projet.entity.BagMaman;

public interface BagMamanService {
    BagMaman saveBagMaman(BagMaman bagMaman);
    BagMaman getBagMamanByMaman(Long idMaman);
    BagMaman updateBagMaman(Long id, BagMaman bagMaman);

}
