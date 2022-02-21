package com.epharmacy.epharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Profile {
    @Id
    private String email;

    private String address;
    private String phoneNumber;
    private String CIN;
    private String InfoCarteBancaire;
    private String InfoLivraison;
    private String image;

    @CreationTimestamp
    @Column(name = "register_at", updatable = false)
    private LocalDateTime register_at;


}
