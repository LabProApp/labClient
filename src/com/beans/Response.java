package com.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Response")
public class Response {
	@Override
	public String toString() {
		return "Response [ERROR_CODE=" + ERROR_CODE + ", ERROR_MESSAGE="
				+ ERROR_MESSAGE + ", STATUS=" + STATUS + "]";
	}

	String ERROR_CODE;
	String ERROR_MESSAGE;
	String STATUS;

	public String getERROR_CODE() {
		return ERROR_CODE;
	}
	@XmlElement
	public void setERROR_CODE(String eRROR_CODE) {
		ERROR_CODE = eRROR_CODE;
	}

	public String getERROR_MESSAGE() {
		return ERROR_MESSAGE;
	}
	@XmlElement
	public void setERROR_MESSAGE(String eRROR_MESSAGE) {
		ERROR_MESSAGE = eRROR_MESSAGE;
	}

	public String getSTATUS() {
		return STATUS;
	}
	@XmlElement
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

}
