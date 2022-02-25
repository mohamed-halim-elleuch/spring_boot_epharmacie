package com.epharmacy.epharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Pharmacie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pharmacieID;
    private String pharmacieNom;
    private String pharmacieAdresse;
    private String  pharmacieTelephone;
    private String  pharmacieFax;
    private String pharmacieEmail;
    private String pharmacieDescription;




}

