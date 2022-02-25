package com.epharmacy.epharmacy.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Medecin {
    @Id
    @GeneratedValue
    private int MedecinID;
    private String nomMedecin;
    private String adresse;
    private String email;
    private int medecinTelephone;
    private int medecinFax;
    private String imageSignatureMedecin;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppUser> users=new ArrayList<>();

    public void ajouterMedecin(){}

    public void actualiserProfil(){}

    public void verifierMedecin(){}

    public void verifierOrdonnance(){}

}
