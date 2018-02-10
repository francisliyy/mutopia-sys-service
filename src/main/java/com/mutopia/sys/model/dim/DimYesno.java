package com.mutopia.sys.model.dim;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dim_yesno database table.
 * 
 */
@Entity
@Table(name="dim_yesno")
@NamedQuery(name="DimYesno.findAll", query="SELECT d FROM DimYesno d")
public class DimYesno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="yesno_id")
	private String yesnoId;

	@Column(name="yesno_name")
	private String yesnoName;

	public DimYesno() {
	}

	public String getYesnoId() {
		return this.yesnoId;
	}

	public void setYesnoId(String yesnoId) {
		this.yesnoId = yesnoId;
	}

	public String getYesnoName() {
		return this.yesnoName;
	}

	public void setYesnoName(String yesnoName) {
		this.yesnoName = yesnoName;
	}

}