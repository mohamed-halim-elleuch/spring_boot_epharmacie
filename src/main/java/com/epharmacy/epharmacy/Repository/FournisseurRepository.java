package com.epharmacy.epharmacy.Repository;
import com.epharmacy.epharmacy.model.Fournisseur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FournisseurRepository extends JpaRepository<Fournisseur,Integer>{

}
