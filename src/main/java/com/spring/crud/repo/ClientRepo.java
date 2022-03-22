package com.spring.crud.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.crud.pojo.Client;

public interface ClientRepo extends JpaRepository<Client, Integer> {

	Client findByClientId(int id);

	Client findByClientName(String name);

	@Query(value = "select Max(total_bill) from client_details GROUP BY total_bill", nativeQuery = true)
	List<Client> fetchClientsWithMaximumBill();

}
