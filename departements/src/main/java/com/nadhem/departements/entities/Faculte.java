package com.nadhem.departements.entities;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Faculte {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String nom;
private String localisation;
@OneToMany(mappedBy = "faculte")
@JsonIgnore
private List<Departement> departements;
public Faculte() {}
public Faculte(String nom, String localisation, List<Departement> departements) 
{
super();
this.nom = nom;
this.localisation = localisation;
this.departements = departements;
}
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getNom() {
return nom;
}
public void setNom(String nom) {
this.nom = nom;
}
public String getLocalisation() {
return localisation;
}
public void setLocalisation(String localisation) {
this.localisation = localisation;
}
public List<Departement> getDepartements() {
return departements;
}
public void setDepartements(List<Departement> departements) {
this.departements = departements;
}
}

