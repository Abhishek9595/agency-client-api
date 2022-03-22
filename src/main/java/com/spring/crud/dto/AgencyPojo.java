package com.spring.crud.dto;

import com.spring.crud.pojo.Client;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgencyPojo {

	private String agencyName;
	private String addressOne;
	private String addressTwo;
	private long mobile;
	private String city;
	private String state;
	private List<Client> clientList;

}
