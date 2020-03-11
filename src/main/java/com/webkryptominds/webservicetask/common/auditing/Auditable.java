package com.webkryptominds.webservicetask.common.auditing;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(
//        value = {"createdBy", "updatedBy", "modifiedBy", "modifiedDate"},
//        allowGetters = true
//)
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PROTECTED)
public abstract class Auditable<U> {

	@CreatedBy
	@Column(nullable = false, updatable = false)
	protected U createdBy;

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = false)
	protected Date createdDate;

	@LastModifiedBy
	protected U modifiedBy;

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	protected Date modifiedDate;
	

}