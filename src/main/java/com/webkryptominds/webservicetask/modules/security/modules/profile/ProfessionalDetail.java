package com.webkryptominds.webservicetask.modules.security.modules.profile;

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
public class ProfessionalDetail extends Auditable<String> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private BigDecimal professionalDetailId;
	
	private BigDecimal professionalMobile;
	
	private String professionalEmailId;
	//private BigDecimal userUid;


	public ProfessionalDetail() {
		
	}

}
