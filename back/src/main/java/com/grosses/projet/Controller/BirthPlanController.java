package com.grosses.projet.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grosses.projet.entity.BirthPlan;
import com.grosses.projet.service.interfaces.BirthPlanService;


@RestController
@RequestMapping("/api/mamans/birthplan")
@CrossOrigin("*")
public class BirthPlanController {
    @Autowired
    BirthPlanService service;


@PostMapping
public BirthPlan saveBirthPlan(@RequestBody BirthPlan birthPlan,@RequestParam(required=false) Long mamanId) {
    return service.saveBirthPlan(birthPlan);
}

    @GetMapping("/{idMaman}")
    public BirthPlan getBirthPlanByMamanId(@PathVariable Long idMaman) {
        return service.getBirthPlanByMaman(idMaman);
    }
    @PutMapping("/{id}")
    public BirthPlan updateBirthPlan(@PathVariable Long id, @RequestBody BirthPlan birthPlan) {
        return service.updateBirthPlan(id, birthPlan);
    }
    
    

}
