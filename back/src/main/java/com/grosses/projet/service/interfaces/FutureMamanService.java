package com.grosses.projet.service.interfaces;
import java.util.List;

import com.grosses.projet.entity.FutureMaman;
public interface FutureMamanService {
    FutureMaman createFutureMaman(FutureMaman futureMaman);
    FutureMaman getFutureMamanById(Long id);
    List<FutureMaman> getAllFutureMamans();
    void deleteFutureMaman(Long id);

}
