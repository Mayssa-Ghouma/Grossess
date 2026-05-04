package com.grosses.projet.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grosses.projet.entity.BagPapa;
import com.grosses.projet.service.interfaces.BagPapaService;

@RestController
@RequestMapping("/api/mamans/bagpapa")
@CrossOrigin("*")
public class BagPapaController {
    @Autowired
    BagPapaService service;


    @PostMapping
    public BagPapa create (@RequestBody BagPapa bagPapa) {
        return service.saveBagPapa(bagPapa);
    }

    @GetMapping("/{idMaman}")
    public BagPapa getBagPapaByMaman(@PathVariable Long idMaman) {
        return service.getBagPapaByMaman(idMaman);
    }

        @PutMapping("/{id}")
    public BagPapa updateBagPapa(@PathVariable Long id, @RequestBody BagPapa bagPapa) {
        return service.updateBagPapa(id, bagPapa);
    }

}
