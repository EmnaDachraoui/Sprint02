package com.nadhem.departements.controllers;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nadhem.departements.entities.Departement;
import com.nadhem.departements.service.DepartementService;
@Controller
public class DepartementController {
@Autowired
DepartementService departementService;

@RequestMapping("/showCreate")
public String showCreate(ModelMap modelMap)
{
modelMap.addAttribute("departement", new Departement());
modelMap.addAttribute("mode", "new");
return "formDepartement";
}

@RequestMapping("/saveDepartement")
public String saveDepartement(@Valid Departement departement,
BindingResult bindingResult)
{
if (bindingResult.hasErrors()) return "formDepartement";
 
departementService.saveDepartement(departement);
return "formDepartement";
}



@RequestMapping("/ListeDepartements")
public String listeDepartements(ModelMap modelMap,
              @RequestParam (name="page",defaultValue = "0") int page,
              @RequestParam (name="size", defaultValue = "2") int size)
{
	Page<Departement> deps = departementService.getAllDepartementsParPage(page, size);
	modelMap.addAttribute("departements", deps);
	 modelMap.addAttribute("pages", new int[deps.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "listeDepartements";
}

@RequestMapping("/supprimerDepartement")
public String supprimerDepartement(@RequestParam("id") Long id,
 ModelMap modelMap, 
 @RequestParam (name="page",defaultValue = "0") int page,
 @RequestParam (name="size", defaultValue = "2") int size)
{ 
	departementService.deleteDepartementById(id);
	Page<Departement> deps = departementService.getAllDepartementsParPage(page, 
			size);
			modelMap.addAttribute("departements", deps);
			modelMap.addAttribute("pages", new int[deps.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
			return "listeDepartements";

}

@RequestMapping("/modifierDepartement")
public String editerDepartement(@RequestParam("id") Long id,ModelMap modelMap)
{
	Departement d= departementService.getDepartement(id);
modelMap.addAttribute("departement", d);
modelMap.addAttribute("mode", "edit");
return "formDepartement";
}

@RequestMapping("/updateDepartement")
public String updateDepartement(@ModelAttribute("departement") Departement departement,
ModelMap modelMap) throws ParseException 
{
 
	departementService.updateDepartement(departement);
 List<Departement> deps = departementService.getAllDepartements();
 modelMap.addAttribute("departements", deps);
return "listeDepartements";
}
}

