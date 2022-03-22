package com.spring.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.crud.pojo.Agency;

public interface AgencyRepo extends JpaRepository<Agency, Integer> {

	Agency findByAgencyId(int id);

	Agency findByAgencyName(String name);

}
