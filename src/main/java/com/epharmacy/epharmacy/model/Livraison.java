package com.epharmacy.epharmacy.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@Data
@Entity
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int livraisonid;
    private String date_livraison;
    private String description_livraison;
    private int prix_livraison;
    private int numero_region_destinataire;

    public void actualiserInfoLivraison(){}

    public int getLivraisonID() {
        return livraisonid;
    }


    @OneToOne(mappedBy = "livraison")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Commande commande;




}
