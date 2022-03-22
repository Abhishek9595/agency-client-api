package com.spring.crud.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgencyDto implements Serializable {

	private String agencyName;
	private String addressOne;
	private String addressTwo;
	private long mobile;
	private String city;
	private String state;

}
