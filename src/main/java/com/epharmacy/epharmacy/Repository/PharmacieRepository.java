package com.epharmacy.epharmacy.Repository;


import com.epharmacy.epharmacy.model.Pharmacie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PharmacieRepository extends JpaRepository<Pharmacie,Integer>{

}
