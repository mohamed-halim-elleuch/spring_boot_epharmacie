package com.epharmacy.epharmacy.model;

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
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int FactureID;

    private Date datePayment;

    private long cardNumber;
    private String cardType;

    @OneToOne(mappedBy = "facture")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Commande commande;


    public int getFactureID() {
        return FactureID;
    }





}
