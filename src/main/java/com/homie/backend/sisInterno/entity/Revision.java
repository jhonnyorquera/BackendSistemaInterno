package com.homie.backend.sisInterno.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

@Entity
@Table(name="revinfo")
@RevisionEntity(CustomRevisionListener.class)
public class Revision implements Serializable {

	@Id
	@Column(name="rev")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@RevisionNumber
	private int rev;

	@Column(name="REVISION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@RevisionTimestamp
	private Date date;

	@Column(name="USER_NAME")
    private String userName;

    public void setUserName(String userName) {
		this.userName = userName;
	}

    public String getUserName() {
		return userName;
	}

    public Date getDate() {
		return date;
	}

	

	public void setDate(Date date) {
		this.date = date;
	}
    
    

}