package com.epharmacy.epharmacy.Repository;


import com.epharmacy.epharmacy.model.CommandeObjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface CommandeObjetRepository extends JpaRepository<CommandeObjet, Long> {
}
