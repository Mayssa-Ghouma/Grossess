package com.grosses.projet.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grosses.projet.entity.Gynecologue;
import com.grosses.projet.service.interfaces.GynecologueService;



@RestController
@RequestMapping("/api/gynecologues")
@CrossOrigin("*")
public class GynecologueController {
    @Autowired
    GynecologueService gynecologueServiceImpl;

    @PostMapping
    public void createGynecologue(@RequestBody Gynecologue gynecologue) {
        gynecologueServiceImpl.createGynecologue(gynecologue);
    }

    @GetMapping
    public List<Gynecologue> getAllGynecologues() {
        return gynecologueServiceImpl.getAllGynecologues();
    }


    
    

}
