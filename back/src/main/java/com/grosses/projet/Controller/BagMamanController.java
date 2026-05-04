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

import com.grosses.projet.entity.BagMaman;
import com.grosses.projet.service.interfaces.BagMamanService;

@RestController
@RequestMapping("/api/mamans/bagmaman")
@CrossOrigin("*")
public class BagMamanController {
    @Autowired
    BagMamanService service;


    @PostMapping
    public BagMaman create (@RequestBody BagMaman bagMaman) {
        return service.saveBagMaman(bagMaman);
    }

    @GetMapping("/{idMaman}")
    public BagMaman getBagMamanByMaman(@PathVariable Long idMaman) {
        return service.getBagMamanByMaman(idMaman);
    }

    @PutMapping("/{id}")
    public BagMaman updateBagMaman(@PathVariable Long id, @RequestBody BagMaman bagMaman) {
        return service.updateBagMaman(id, bagMaman);
    }

}
