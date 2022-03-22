package com.spring.crud.service;

import java.util.List;

import com.spring.crud.dto.AgencyPojo;
import com.spring.crud.pojo.Agency;
import com.spring.crud.pojo.Client;
import com.spring.crud.response.ClientDto;

public interface AppService {

	Agency registerAgency(AgencyPojo agencyPojo);

	Client updateClient(ClientDto client);

	List<Agency> fetchAgencyWithTopClient();

}
