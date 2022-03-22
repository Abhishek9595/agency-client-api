package com.spring.crud.controller;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.crud.dto.AgencyPojo;
import com.spring.crud.pojo.Agency;
import com.spring.crud.pojo.Client;
import com.spring.crud.response.ClientDto;
import com.spring.crud.response.ResponseMessage;
import com.spring.crud.service.AppService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResourceController {

	@Autowired
	private AppService service;

	@PostMapping("/register-client-agency")
	public ResponseEntity<ResponseMessage> registerAgencyAndClient(@RequestBody AgencyPojo agency) {
		service.registerAgency(agency);
		ResponseMessage message = new ResponseMessage(false, "Client and Agency Registered Successfully", agency);
		log.info("Client and Agency Registered Successfully {} " + agency);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@PutMapping("/update-client")
	public ResponseEntity<ResponseMessage> updateClient(@RequestBody ClientDto client) {
		Client updateClient = service.updateClient(client);
		log.info("Data Updated Successfully {} " + updateClient);
		return new ResponseEntity<>(
				new ResponseMessage(false, client.getClientName() + " Data Updated Successfully", updateClient),
				HttpStatus.OK);
	}

	@GetMapping("/fetch-top-billing-clients")
	public ResponseEntity<ResponseMessage> fetchTopBillingClients() {
		List<Agency> fetchAgencyWithTopClient = service.fetchAgencyWithTopClient();
		// Stream<AgencyPojo> map = fetchAgencyWithTopClient.stream().map(agency-> new
		// AgencyPojo(agency.getAgencyName(), agency.getAddressOne(),
		// agency.getAddressTwo(), agency.getMobile(), agency.getCity(),
		// agency.getState(), agency.getClientList()));
		log.info("Agency with top billing clients {} " + fetchAgencyWithTopClient);
		return new ResponseEntity<>(
				new ResponseMessage(false, "Agency with top billing clients", fetchAgencyWithTopClient), HttpStatus.OK);
	}

}
