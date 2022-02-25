package com.epharmacy.epharmacy.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


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
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime created_at;

    @ManyToOne
    private Article article;
}
