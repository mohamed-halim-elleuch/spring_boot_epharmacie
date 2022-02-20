package com.epharmacy.epharmacy.model;

import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@Data
@Entity
public class Facture {
    @Id
    private int FactureID;
    private String articleNom;
    private int quantite;
    private double prixUnitaire;
    private double SousTotal = quantite * prixUnitaire;

    public double CalculerPrix(){
        return quantite * prixUnitaire * 1.19;
    }

    public int getFactureID() {
        return FactureID;
    }

    @ManyToOne
    @JoinColumn(name="commandeid")
    private Commande commande;


}
