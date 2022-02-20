package com.epharmacy.epharmacy.Repository;


import com.epharmacy.epharmacy.model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface FactureRepository extends JpaRepository<Facture,Long> {
}
