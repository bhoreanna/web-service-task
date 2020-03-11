package com.webkryptominds.webservicetask.modules.security.modules.usermaster;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.webkryptominds.webservicetask.common.auditing.Auditable;
import com.webkryptominds.webservicetask.modules.security.modules.address.Address;
import com.webkryptominds.webservicetask.modules.security.modules.personal.Personal;
import com.webkryptominds.webservicetask.modules.security.modules.profile.ProfessionalDetail;
import com.webkryptominds.webservicetask.modules.security.modules.rolemaster.RoleMaster;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity

@Table(name="User_Master")
@Data
@Setter
@Getter
public class UserMaster extends Auditable<String> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private BigDecimal userUid;
	
	private String userId ;
	private String userName;
	private String userStatus ;
	private String password  ;
	private String email    ; 
	
	@JoinColumn(name = "roleUid")
    @OneToOne()
	private RoleMaster roleMaster ;
	
	
	
    @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "professionalDetailId")
    //@OneToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER, orphanRemoval = false)
//	@JoinColumn(name = "userUid", referencedColumnName="userUid")
	private ProfessionalDetail professionalDetail  ;
	
    @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "addressId")
   // @OneToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER, orphanRemoval = false)
//	@JoinColumn(name = "userUid", referencedColumnName="userUid")
	private Address address ;
	
    @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "personalId")
    //@OneToOne(cascade = CascadeType.ALL, fetch= FetchType.EAGER, orphanRemoval = false)
	//@JoinColumn(name = "userUid", referencedColumnName="userUid")
	private Personal personal  ;



	


}
