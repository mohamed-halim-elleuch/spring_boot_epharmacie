package com.epharmacy.epharmacy.Controller;


import com.epharmacy.epharmacy.Repository.FactureRepository;

import com.epharmacy.epharmacy.model.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class FactureController {

    @Autowired
    private FactureRepository factureRepo;

    @PostMapping("/AddFacture")
    public String saveFacture(@RequestBody Facture facture){
        factureRepo.save(facture);
        return "Added Facture with id : " + facture.getFactureID();
    }

    @GetMapping("/findAllFactures")
    public List<Facture> findAllFactures(){
        return factureRepo.findAll();
    }

    @GetMapping("/findAllFactures/{id}")
    public Facture getFacture(@PathVariable Long id){
        return factureRepo.getById(id);
    }

    @DeleteMapping("/deleteFacture/{id}")
    public String deleteFacture(@PathVariable Long id) {
        factureRepo.deleteById(id);
        return "facture deleted with id : " + id;
    }
}
