package com.epharmacy.epharmacy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommandeObjet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commandObjectID;

    private int quantity;
    private double price;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Commande commande;

    @ManyToOne
    private Article article;
}
