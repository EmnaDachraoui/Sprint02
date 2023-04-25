package com.nadhem.departements.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Departement {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long idDepartement;
@NotNull
@Size (min = 4,max = 15)
private String nomDepartement;

@NotNull
@Size (min = 4,max = 20)
private String description;

@ManyToOne
private Faculte faculte;


public Faculte getFaculte() {
	return faculte;
}
public void setFaculte(Faculte faculte) {
	this.faculte = faculte;
}
public Departement() {
super();
}
public Departement(String nomDepartement, String description) {
super();
this.nomDepartement = nomDepartement;
this.description = description;
}
public Long getIdDepartement() {
return idDepartement;
}
public void setIdDepartement(Long idDepartement) {
this.idDepartement = idDepartement;
}
public String getNomDepartement() {
return nomDepartement;
}
public void setNomDepartement(String nomDepartement) {
this.nomDepartement = nomDepartement;
}
public String getDescription() {
return description;
}
public void setDescription(String description) {
this.description = description;
}

@Override
public String toString() {
return "Produit [IdDepartement=" + idDepartement + ", nomDepartement=" + 
		nomDepartement + ", Description=" + description ;
}
}
