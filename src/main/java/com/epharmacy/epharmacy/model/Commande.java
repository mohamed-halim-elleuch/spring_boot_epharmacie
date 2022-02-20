package com.epharmacy.epharmacy.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
@Data
@Entity
public class Commande implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commandeid;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name="nom_client")
    private String nom_client;

    @Column(name="statut")
    private String statut;

    @Column(name="numero_envoi")
    private int numero_envoi;

    public int getId() {
        return commandeid;
    }

    @OneToMany(mappedBy="commande")
    private Set<Livraison> livraisons;

    @OneToMany(mappedBy="commande")
    private Set<Facture> factures;

}
