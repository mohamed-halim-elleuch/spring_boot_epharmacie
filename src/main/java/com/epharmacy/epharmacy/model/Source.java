package com.epharmacy.epharmacy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="Source")
public class Source {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String SourceType;
    @OneToMany(mappedBy = "source")
    private List<Article> Articles;

    public void UpdateSource(){}
    public void SourceDetail(){}

}

