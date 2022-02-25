package com.epharmacy.epharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fournisseurID;
    private String fournisseurNom;
    private String fournisseurAdresse;
    private String  fournisseurTelephone;
    private String  fournisseurFax;
    private String fournisseurEmail;
    private String fournisseurDescription;
}
