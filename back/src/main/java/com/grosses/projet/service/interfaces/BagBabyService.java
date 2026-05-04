package com.grosses.projet.service.interfaces;

import com.grosses.projet.entity.BagBaby;

public interface BagBabyService {
    BagBaby saveBagBaby(BagBaby bagBaby);
    BagBaby getBagBabyByMaman(Long idMaman);
    BagBaby updateBagBaby(Long id, BagBaby bagBaby);

}
