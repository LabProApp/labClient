package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "LAB_BRANCH_REP")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "LabRep")
public class LabRep {

	
	
	@Override
	public String toString() {
		return "LabRep [labRepresentativeId=" + labRepresentativeId
				+ ", primaryMobileNo=" + primaryMobileNo + ", repName="
				+ repName + ", labbranchCode=" + labbranchCode + ", status="
				+ status + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LAB_REP_ID", unique = true)
	Long labRepresentativeId;
	@Column(name = "PRIM_MOBILE")
	String primaryMobileNo;
	@Column(name = "REP_NAME")
	String repName;
	@Column(name = "LAB_BRANCH_CD", nullable = false)
	Long labbranchCode;
	@Column(name = "STATUS")
	Integer status;
	
	public Long getLabRepresentativeId() {
		return labRepresentativeId;
	}
	@XmlElement
	public void setLabRepresentativeId(Long labRepresentativeId) {
		this.labRepresentativeId = labRepresentativeId;
	}
	public String getPrimaryMobileNo() {
		return primaryMobileNo;
	}
	@XmlElement
	public void setPrimaryMobileNo(String primaryMobileNo) {
		this.primaryMobileNo = primaryMobileNo;
	}
	public String getRepName() {
		return repName;
	}
	@XmlElement
	public void setRepName(String repName) {
		this.repName = repName;
	}
	public Long getLabbranchCode() {
		return labbranchCode;
	}
	@XmlElement
	public void setLabbranchCode(Long labbranchCode) {
		this.labbranchCode = labbranchCode;
	}
	public Integer getStatus() {
		return status;
	}
	@XmlElement
	public void setStatus(Integer status) {
		this.status = status;
	}

}
