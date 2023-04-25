package com.nadhem.departements.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.nadhem.departements.entities.Departement;
import com.nadhem.departements.entities.Faculte;

public interface DepartementService {
	Departement saveDepartement(Departement d);
	Departement updateDepartement(Departement d);
void deleteDepartement(Departement d);
 void deleteDepartementById(Long id);
 Departement getDepartement(Long id);
List<Departement> getAllDepartements();
List<Departement> findByNomDepartement(String nom);
List<Departement> findByNomDepartementContains(String nom);
List<Departement> findByNomId (String nom, Long id);
List<Departement> findByFaculte (Faculte faculte);
List<Departement> findByFaculteId(Long id);
List<Departement> findByOrderByNomDepartementAsc();
List<Departement> trierDepartementsNomsId();


Page<Departement> getAllDepartementsParPage(int page, int size);

}

