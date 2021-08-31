package marsa.maroc.GestionNavires.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import marsa.maroc.GestionNavires.entities.Grue;
@RepositoryRestResource
public interface GrueRepository extends JpaRepository<Grue, Long>{
	
}
