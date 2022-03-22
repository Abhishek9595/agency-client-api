package com.spring.crud.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client_details")
public class Client implements Serializable {

	@Id
	@SequenceGenerator(name = "client_sequence", initialValue = 100, allocationSize = 2)
	@GeneratedValue(generator = "client_sequence")
	private int clientId;
	private String clientName;
	private String email;
	private long mobile;
	private double totalBill;

}
