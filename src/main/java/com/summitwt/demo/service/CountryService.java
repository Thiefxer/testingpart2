package com.summitwt.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.summitwt.demo.model.*;
import com.summitwt.demo.repo.CountryRepository;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepo;

	public List<Country> getCountryList() {
		// List<Country> countryList=new ArrayList<Country>();
		// countryList.add(new Country(1,"United States","Washington D.C.", 320000000));
		// countryList.add(new Country(2,"Canada","Ottawa.", 40000000));
		// countryList.add(new Country(3,"France","Paris", 80000000));
		// countryList.add(new Country(4,"United Kingdom","London", 100000000));
		return countryRepo.findAll();
	}

	public void delete(int id) {
		countryRepo.deleteById(id);
	}

	public Country get(int i) {
		return countryRepo.findById(i).get();
	}

	public void saveCountry(Country e) {
		countryRepo.save(e);
	}
}
