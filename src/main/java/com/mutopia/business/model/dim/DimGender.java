package com.mutopia.business.model.dim;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dim_gender database table.
 * 
 */
@Entity
@Table(name="dim_gender")
@NamedQuery(name="DimGender.findAll", query="SELECT d FROM DimGender d")
public class DimGender implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="gender_id")
	private String genderId;

	@Column(name="gender_name")
	private String genderName;

	public DimGender() {
	}

	public String getGenderId() {
		return this.genderId;
	}

	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}

	public String getGenderName() {
		return this.genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

}