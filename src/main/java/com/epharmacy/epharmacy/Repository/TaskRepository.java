package com.epharmacy.epharmacy.Repository;

import com.epharmacy.epharmacy.model.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TaskRepository extends JpaRepository<Task,Long> {

}
