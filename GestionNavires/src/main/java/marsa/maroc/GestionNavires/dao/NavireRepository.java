package marsa.maroc.GestionNavires.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import marsa.maroc.GestionNavires.entities.Navire;
@RepositoryRestResource
public interface NavireRepository extends JpaRepository<Navire, Long>{

}
