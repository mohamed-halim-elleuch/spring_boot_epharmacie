package com.epharmacy.epharmacy.Controller;


import com.epharmacy.epharmacy.Repository.CommandeRepository;
import com.epharmacy.epharmacy.Repository.FactureRepository;

import com.epharmacy.epharmacy.model.AppUser;
import com.epharmacy.epharmacy.model.Commande;
import com.epharmacy.epharmacy.model.Facture;
import com.epharmacy.epharmacy.model.Medecin;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RequestMapping("/api")
@RestController
public class FactureController {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private FactureRepository factureRepo;

    @PostMapping("/AddFacture")
    public Facture saveFacture(@RequestBody FactureForm factureForm){
        Commande commande = new Commande();
        commande.setCommandeid(factureForm.getCommande().getCommandeid());
        commande=commandeRepository.save(commande);
        System.out.println(commande.getId());


        Facture facture = new Facture();
        facture=factureRepo.save(factureForm.getFacture());
        return facture;
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

@Data
class FactureForm{
    private Commande commande = new Commande();
    private Facture facture = new Facture();
}
