package com.summitwt.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.summitwt.demo.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>
{

}
