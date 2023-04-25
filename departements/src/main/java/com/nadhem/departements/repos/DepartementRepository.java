package com.nadhem.departements.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.nadhem.departements.entities.Departement;
import com.nadhem.departements.entities.Faculte;

@RepositoryRestResource(path = "rest")
public interface DepartementRepository extends JpaRepository<Departement, Long> {

	List<Departement> findByNomDepartement (String nom);
	List<Departement> findByNomDepartementContains (String nom);
	
	
	@Query("select d from Departement d where d.nomDepartement like %?1 and d.idDepartement > ?2")
	List<Departement> findByNomId (String nom, Long id);
	
	
	@Query("select d from Departement d where d.faculte = ?1")
	List<Departement> findByFaculte (Faculte faculte);

	
	List<Departement> findByFaculteId(Long id);

	List<Departement> findByOrderByNomDepartementAsc();
	
	
	@Query("select d from Departement d order by d.nomDepartement ASC, d.idDepartement DESC")
	List<Departement> TrierDepartementsNomsId();

}
