package com.epharmacy.epharmacy.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
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



    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "commande")
    private Collection<CommandeObjet> commandeObjets;

    private double totalAmount;

    @Column(name="statut")
    private String statut;


    @OneToOne
    private Facture facture;

    @OneToOne
    private Livraison livraison;

    @ManyToOne
    private AppUser appUser;

    public int getId() {
        return commandeid;
    }

}
