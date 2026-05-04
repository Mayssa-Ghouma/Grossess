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

import com.grosses.projet.entity.BagBaby;
import com.grosses.projet.service.interfaces.BagBabyService;


@RestController
@RequestMapping("/api/mamans/bagbaby")
@CrossOrigin("*")
public class BagBabyController {
    @Autowired
    BagBabyService service;


    @PostMapping
    public BagBaby create (@RequestBody BagBaby bagBaby) {
        return service.saveBagBaby(bagBaby);
    }

    @GetMapping("/{idMaman}")
    public BagBaby getBagBabyByMaman(@PathVariable Long idMaman) {
        return service.getBagBabyByMaman(idMaman);
    }

        @PutMapping("/{id}")
    public BagBaby updateBagBaby(@PathVariable Long id, @RequestBody BagBaby bagBaby) {
        return service.updateBagBaby(id, bagBaby);
    }
    

}
