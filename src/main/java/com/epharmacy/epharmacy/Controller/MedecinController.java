package com.epharmacy.epharmacy.Controller;


import com.epharmacy.epharmacy.Repository.AppUserRepository;
import com.epharmacy.epharmacy.Repository.MedecinRepository;
import com.epharmacy.epharmacy.model.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class MedecinController {
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private MedecinRepository medecinRepository;

    @PostMapping("/addmedecin")
    public Medecin saveMedecin(@RequestBody MedecinForm medecinForm){
        AppUser appUser = new AppUser();
        appUser.setUsername(medecinForm.getAppUser().getUsername());
        appUser=appUserRepository.save(appUser);
        System.out.println(appUser.getId());

        Medecin medecin=new Medecin();
        medecin.setUsers((Collection<AppUser>) appUser);
        medecin=medecinRepository.save(medecin);
        return medecin;
    }

    @GetMapping("/findAllMedecins")
    public List<Medecin> findAllMedecins(){
        return medecinRepository.findAll();
    }

    @GetMapping("/findAllMedecins/{id}")
    public Medecin getMedecin(@PathVariable Integer id){
        return medecinRepository.getById(id.longValue());
    }

    @DeleteMapping("/deleteMedecin/{id}")
    public String deleteMedecin(@PathVariable Integer id) {
        medecinRepository.deleteById(id.longValue());
        return "student deleted with id : " + id;
    }
}

