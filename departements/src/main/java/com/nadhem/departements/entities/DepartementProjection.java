package com.nadhem.departements.entities;
import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomDep", types = {Departement.class })
public interface DepartementProjection {
public String getNomDepartement();
}