package com.epharmacy.epharmacy.Repository;

import com.epharmacy.epharmacy.model.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MedecinRepository extends JpaRepository<Medecin,Long>{
}
