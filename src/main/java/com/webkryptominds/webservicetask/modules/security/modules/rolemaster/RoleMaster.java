package com.webkryptominds.webservicetask.modules.security.modules.rolemaster;

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

@Table(name="Role_Master")
@Data
@Setter
@Getter

public class RoleMaster extends Auditable<String> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private BigDecimal roleUid;
	
	private String roleId;
	private String roleName;
	
	private String userRoleStatus;

//	
//	//@JsonManagedReference
//	@ManyToMany()	
//	//@ManyToMany(cascade=CascadeType.ALL)	
//
//		    @JoinTable(name = "ROLE_MODULE_Master",joinColumns = @JoinColumn(name = "ROLE_UID"),
//		        inverseJoinColumns = @JoinColumn(name = "MODULE_UID")
//		    )
//		    private List<ModuleMaster> moduleMasterList = new ArrayList<>();





	
	


	 
	 
	 
}
