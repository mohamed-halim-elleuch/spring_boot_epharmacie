package com.epharmacy.epharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data

@NoArgsConstructor
@ToString
@Entity
@Table(name="Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Categoryid;
    private String CategoryNom;

    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    private List<Article> Articles;

    public Category(Object o, String antiviraux) {
        this.Categoryid = (Long) o;
        this.CategoryNom = antiviraux;
    }


    public void UpdateCategory(String categoryNom){
        CategoryNom = categoryNom;
    }
    public String CategoryDetail(){
        return CategoryNom;
    }

}

