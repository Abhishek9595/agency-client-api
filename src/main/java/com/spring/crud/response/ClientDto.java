package com.spring.crud.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto implements Serializable {

	private String clientName;
	private String email;
	private long mobile;
	private double totalBill;

}
