package com.summitwt.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.summitwt.demo.service.CountryService;
import com.summitwt.demo.model.*;
import java.util.*;

import javax.validation.Valid;

@Controller
public class CountryController {

	@Autowired
	CountryService countryService;

	@RequestMapping("/list_countries")
	public String getCountryList(Model model) {
		List<Country> list = countryService.getCountryList();
		model.addAttribute("countries", list);
		return "allindex"; // here its a view name,
	}
	@RequestMapping("/countries")
	public String getCountry(Model model) {
		List<Country> list = countryService.getCountryList();
		model.addAttribute("countries", list);
		return "allindex"; // here its a view name,
	}

	@RequestMapping("/")
	public String welcome(Model model) {
		 List<Country> countries = countryService.getCountryList();
	        model.addAttribute("keyContries", countries);
	        return "list_countriesHL" ;
	}
	
	@RequestMapping("/getCountry/{id}")
    public String getCountryById(@PathVariable (name = "id") int id, Model model) {
        model.addAttribute("countryKey", countryService.get(id));
        return "countryInfo"; 
    }
    @RequestMapping("/countriesListHL")
    public String getListCountryHyperLink(Model model) {
        List<Country> countries = countryService.getCountryList();
        model.addAttribute("keyContries", countries);
        return "list_countriesHL" ;//this is the view name list_countries.html
    }
	@RequestMapping("/delete/{id}")
	public String deleteCountry(@PathVariable(name = "id") int id) {
		countryService.delete(id);
		return "redirect:/list_countries";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditEmployeePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_country");
		Country emp = countryService.get(id);
		mav.addObject("country", emp);
		return mav;

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCountry(@Valid@ModelAttribute("country") Country country,BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			List<Country> list = countryService.getCountryList();
			model.addAttribute("countries", list);
			return "redirect:/edit/{id}";
		}else {
			countryService.saveCountry(country);
			return "redirect:/list_countries";
		}
	}

	@RequestMapping("/new")
	public String newEmployee(Model model) {
		Country e = new Country();
		model.addAttribute("country", e);
		return "newcountry";
	}

	@RequestMapping("/test")
	public String testMethod(Model model) {
		model.addAttribute("message", "welcome to spring MVC");
		return "welcome";
	}

}
