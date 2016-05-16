package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "SPECIALITY")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Speciality")
public class Speciality {

	@Override
	public String toString() {
		return "Speciality [specId=" + specId + ", specName=" + specName
				+ ", search_tags=" + search_tags + ", status=" + status + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SPEC_ID", unique = true)
	Long specId;

	@Column(name = "SPEC_NAME")
	String specName;
	@Column(name = "SEARCH_TAGS")
	String search_tags;
	@Column(name = "STATUS")
	Integer status;

	public Long getSpecId() {
		return specId;
	}

	@XmlElement
	public void setSpecId(Long specId) {
		this.specId = specId;
	}

	public String getSpecName() {
		return specName;
	}

	@XmlElement
	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public String getSearch_tags() {
		return search_tags;
	}

	@XmlElement
	public void setSearch_tags(String search_tags) {
		this.search_tags = search_tags;
	}

	public Integer getStatus() {
		return status;
	}

	@XmlElement
	public void setStatus(Integer status) {
		this.status = status;
	}

}
