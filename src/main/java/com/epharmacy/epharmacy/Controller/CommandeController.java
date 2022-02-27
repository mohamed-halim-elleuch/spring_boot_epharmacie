package com.epharmacy.epharmacy.Controller;

import com.epharmacy.epharmacy.Repository.AppUserRepository;
import com.epharmacy.epharmacy.Repository.ArticleRepository;
import com.epharmacy.epharmacy.Repository.CommandeObjetRepository;
import com.epharmacy.epharmacy.Repository.CommandeRepository;
import com.epharmacy.epharmacy.model.AppUser;
import com.epharmacy.epharmacy.model.Article;
import com.epharmacy.epharmacy.model.Commande;
import com.epharmacy.epharmacy.model.CommandeObjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/api")
@RestController
public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private CommandeObjetRepository commandeObjetRepository;
    @PostMapping("/addcommandes")
    public Commande saveCommande(@RequestBody CommandeForm commandeForm){
        AppUser appUser=new AppUser();
        System.out.println(commandeForm);
        appUser.setUsername(commandeForm.getAppUser().getUsername());
        appUser=appUserRepository.save(appUser);
        System.out.println(appUser.getId());

        Commande commande=new Commande();
        commande.setAppUser(appUser);
        commande=commandeRepository.save(commande);
        double total=0;
        for(CommandeAricle p:commandeForm.getAricles()){
            CommandeObjet commandeObjet=new CommandeObjet();
            commandeObjet.setCommande(commande);
            Article article=articleRepository.findById(Math.toIntExact(p.getId())).get();
            commandeObjet.setArticle(article);
            commandeObjet.setPrice(article.getArticlePrice());
            commandeObjet.setQuantity(p.getQuantity());
            commandeObjetRepository.save(commandeObjet);
            total+=p.getQuantity()*article.getArticlePrice();
        }
        commande.setTotalAmount(total);
        return commandeRepository.save(commande);
    }

    @GetMapping("/findAllCommandes")
    public List<Commande> findAllCommandes(){
        return commandeRepository.findAll();
    }

    @GetMapping("/findAllCommandes/{id}")
    public Commande getCommande(@PathVariable Integer id){
        return commandeRepository.getById(id);
    }

    @DeleteMapping("/deleteCommande/{id}")
    public String deleteCommande(@PathVariable Integer id) {
        commandeRepository.deleteById(id);
        return "student deleted with id : " + id;
    }
}
