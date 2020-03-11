package com.webkryptominds.webservicetask.modules.security.modules.address;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.webkryptominds.webservicetask.common.auditing.Auditable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity

@Table
@Data
@Setter
@Getter
public class Address extends Auditable<String> implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private BigDecimal addressId;
	private BigDecimal pincode;
	private String city;
	private String state;
	private String country;
//	private BigDecimal userUid;

	
	public Address() {
		// TODO Auto-generated constructor stub
	}

}
