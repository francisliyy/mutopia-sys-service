package com.mutopia.sys.model.dim;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dim_status database table.
 * 
 */
@Entity
@Table(name="dim_status")
@NamedQuery(name="DimStatus.findAll", query="SELECT d FROM DimStatus d")
public class DimStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="status_id")
	private String statusId;

	@Column(name="status_name")
	private String statusName;

	public DimStatus() {
	}

	public String getStatusId() {
		return this.statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}