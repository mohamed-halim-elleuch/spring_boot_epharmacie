package com.epharmacy.epharmacy.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.*;

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


    //@OneToMany(targetEntity = Commande.class,cascade = CascadeType.ALL)
    //@JoinColumn(name ="commandeid",referencedColumnName = "commandeid")
    //private List<Integer> commandes_id;



    @ManyToOne
    @JoinColumn(name="commandeid")
    private Commande commande;

}
