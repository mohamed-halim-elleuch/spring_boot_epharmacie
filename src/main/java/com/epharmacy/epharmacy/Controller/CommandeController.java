package com.epharmacy.epharmacy.Controller;

import com.epharmacy.epharmacy.Repository.CommandeRepository;
import com.epharmacy.epharmacy.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepo;

    @PostMapping("/AddCommande")
    public Commande saveCommande(@RequestBody Commande commande){
        commandeRepo.save(commande);
        return commande;
    }

    @GetMapping("/findAllCommandes")
    public List<Commande> findAllCommandes(){
        return commandeRepo.findAll();
    }

    @GetMapping("/findAllCommandes/{id}")
    public Commande getCommande(@PathVariable Integer id){
        return commandeRepo.getById(id);
    }

    @DeleteMapping("/deleteCommande/{id}")
    public String deleteCommande(@PathVariable Integer id) {
        commandeRepo.deleteById(id);
        return "student deleted with id : " + id;
    }
}
