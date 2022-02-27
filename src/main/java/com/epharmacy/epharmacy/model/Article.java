package com.epharmacy.epharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Article")
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private int ArticleID;
    private String ArticleNom;
    private int ArticlePrice;
    private boolean promotion;
    private boolean selected;
    private boolean available;
    private int StockQuantity;
    private int Rate;
    private int RateDiscount;
    private String ArticleImage;
    @Column(columnDefinition = "TEXT")
    private String ArticleDescription;
    @Transient
    private int quantity=1;

    @ManyToOne
    @JoinColumn(name = "SourceType")
    private Source source;

    @ManyToOne
    @JoinColumn(name = "Category")
    private Category category;
    @ManyToOne
    private Pharmacie pharmacie;
    @ManyToOne
    private Fournisseur fournisseur;


    //
    public void AddArticle(){}
    public void UpdateArticle(){}
    public void DeleteArticle(){}
    public void ArticleDetails(){}
}
