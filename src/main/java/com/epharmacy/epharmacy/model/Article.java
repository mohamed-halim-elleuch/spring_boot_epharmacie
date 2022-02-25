package com.epharmacy.epharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long ArticleID;
    private String ArticleNom;
    private int ArticlePrice;
    private int StockQuantity;
    private int RateTva;
    private int RateDiscount;
    private String ArticleImage;
    private String ArticleDescription;

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
