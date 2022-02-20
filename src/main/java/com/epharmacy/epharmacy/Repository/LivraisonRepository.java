package com.epharmacy.epharmacy.Repository;



import com.epharmacy.epharmacy.model.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LivraisonRepository extends JpaRepository<Livraison,Long>{

}
