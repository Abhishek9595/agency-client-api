package com.spring.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.crud.dto.AgencyPojo;
import com.spring.crud.exception.ClientNotFoundException;
import com.spring.crud.pojo.Agency;
import com.spring.crud.pojo.Client;
import com.spring.crud.repo.AgencyRepo;
import com.spring.crud.repo.ClientRepo;
import com.spring.crud.response.ClientDto;

@Service
public class AppServiceImpl implements AppService {

	@Autowired
	private AgencyRepo agencyRepo;

	@Autowired
	private ClientRepo clientRepo;

	@Override
	public Agency registerAgency(AgencyPojo agencyPojo) {
		Agency agency = new Agency();
		BeanUtils.copyProperties(agencyPojo, agency);
		agency.setClientList(agencyPojo.getClientList());
		return agencyRepo.save(agency);
	}

	@Override
	public Client updateClient(ClientDto client) throws ClientNotFoundException {
		Client UpdateClient = clientRepo.findByClientName(client.getClientName());
		if (UpdateClient == null) {
			throw new ClientNotFoundException("Client Not Found....");
		}
		BeanUtils.copyProperties(client, UpdateClient);
		return clientRepo.save(UpdateClient);
	}

	@Override
	public List<Agency> fetchAgencyWithTopClient() {
		List<Agency> agencyList = agencyRepo.findAll();
//		List<Agency> returnList = new ArrayList<>();
//		Agency agency = new Agency();
		List<Client> fetchClientsWithMaximumBill = clientRepo.fetchClientsWithMaximumBill();
//		agency.setClientList(fetchClientsWithMaximumBill);
		List<Boolean> collect = agencyList.stream()
				.map(agency1 -> agency1.getClientList().equals(fetchClientsWithMaximumBill))
				.collect(Collectors.toList());
		if (collect.equals(Boolean.TRUE)) {
			return agencyList;
		}
		return null;
	}

}
