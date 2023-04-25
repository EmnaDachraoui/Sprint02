package com.nadhem.departements.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nadhem.departements.entities.Departement;
import com.nadhem.departements.entities.Faculte;
import com.nadhem.departements.repos.DepartementRepository;
@Service
public class DepartementServiceImpl implements DepartementService {
@Autowired
DepartementRepository departementRepository;
@Override
public Departement saveDepartement(Departement d) {
return departementRepository.save(d);
}
@Override
public Departement updateDepartement(Departement d) {
return departementRepository.save(d);
}
@Override
public void deleteDepartement(Departement d) {
	departementRepository.delete(d);
}
 @Override
public void deleteDepartementById(Long id) {
	 departementRepository.deleteById(id);
}
@Override
public Departement getDepartement(Long id) {
return departementRepository.findById(id).get();
}
@Override
public List<Departement> getAllDepartements() {
return departementRepository.findAll();
}
@Override
public Page<Departement> getAllDepartementsParPage(int page, int size) {
	return departementRepository.findAll(PageRequest.of(page, size));
}
@Override
public List<Departement> findByNomDepartement(String nom) {
	
	return departementRepository.findByNomDepartement(nom);
}
@Override
public List<Departement> findByNomDepartementContains(String nom) {

	return departementRepository.findByNomDepartementContains(nom);
}
@Override
public List<Departement> findByNomId(String nom, Long id) {

	return departementRepository.findByNomId(nom, id);
}
@Override
public List<Departement> findByFaculte(Faculte faculte) {
	
	return departementRepository.findByFaculte(faculte);
}
@Override
public List<Departement> findByFaculteId(Long id) {
	
	return departementRepository.findByFaculteId(id);
}
@Override
public List<Departement> findByOrderByNomDepartementAsc() {
	
	return departementRepository.findByOrderByNomDepartementAsc();
}
@Override
public List<Departement> trierDepartementsNomsId(){
	
	return departementRepository.TrierDepartementsNomsId();
}
}
