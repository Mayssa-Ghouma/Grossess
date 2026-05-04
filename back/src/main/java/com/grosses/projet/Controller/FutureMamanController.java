package com.grosses.projet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grosses.projet.entity.FutureMaman;
import com.grosses.projet.service.interfaces.FutureMamanService;



@RestController
@RequestMapping("/api/mamans")
@CrossOrigin("*")
public class FutureMamanController {
    @Autowired
    FutureMamanService service;

    @PostMapping
    public void createFutureMaman(@RequestBody FutureMaman futureMaman){
        service.createFutureMaman(futureMaman);
    }

    @GetMapping("/{id}")
    public FutureMaman getFutureMamanById(@PathVariable Long id){
        return service.getFutureMamanById(id);
    }

    @GetMapping
    public List<FutureMaman> getAllFutureMamans(){
        return service.getAllFutureMamans();
    }

    @DeleteMapping("/{id}")
    public void deleteFutureMaman(@PathVariable Long id){
        service.deleteFutureMaman(id);}

}
