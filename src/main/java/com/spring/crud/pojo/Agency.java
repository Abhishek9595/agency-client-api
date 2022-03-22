package com.spring.crud.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "agency_details")
public class Agency implements Serializable {

	@Id
	@SequenceGenerator(name = "agency_sequence", initialValue = 100, allocationSize = 2)
	@GeneratedValue(generator = "agency_sequence")
	private int agencyId;
	private String agencyName;
	private String addressOne;
	private String addressTwo;
	private long mobile;
	private String city;
	private String state;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "agencyId")
	private List<Client> clientList;

}
