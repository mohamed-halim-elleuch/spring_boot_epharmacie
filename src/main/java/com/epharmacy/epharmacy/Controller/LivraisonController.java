package com.epharmacy.epharmacy.Controller;

import com.epharmacy.epharmacy.Repository.LivraisonRepository;
import com.epharmacy.epharmacy.model.Livraison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LivraisonController {
    @Autowired
    private LivraisonRepository livraisonRepo;

    @PostMapping("/AddLivraison")
    public String saveLivraison(@RequestBody Livraison livraison){
        livraisonRepo.save(livraison);
        return "Added Livraison with id : " + livraison.getLivraisonID();
    }

    @GetMapping("/findAllLivraisons")
    public List<Livraison> findAllLivraisons(){
        return livraisonRepo.findAll();
    }

    @GetMapping("/findAllLivraisons/{id}")
    public Livraison getLivraison(@PathVariable Long id){
        return livraisonRepo.getById(id);
    }

    @DeleteMapping("/deleteLivraison/{id}")
    public String deleteLivraison(@PathVariable Long id) {
        livraisonRepo.deleteById(id);
        return "Livraison deleted with id : " + id;
    }
}
