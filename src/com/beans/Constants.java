package com.beans;

public class Constants {

	public static final String MORNING = "MORNING";
	public static final String AFTERNOON = "AFTERNOON";
	public static final String EVENING = "EVENING";
	public static final String NIGHT = "NIGHT";
	public static final String PATIENT = "PATIENT";
	public static final String DOCTOR = "DOCTOR";
	public static final String LAB_OFFICE = "LAB_OFFICE";
	public static final String LAB_BRANCH = "LAB_BRANCH";
	
	
	public static Integer PENDNG_ACTIVATE = 12;
	public static Integer DELETED = 14;
	public static Integer ACTIVE = 11;

	
	public static String RESP_SUCCESS = "0000";
	public static String RESP_FAIL = "0001";
	public static String RESP_NORECORD = "0002";
	public static String RESP_ALREADYEXISTS = "0003";
	public static String RESP_DBERROR = "0010";
	public static String RESP_CONNERROR = "0011";
	public static final String RESP_OTP_EXPIRED = "0012";
	public static final String FAIL = "FAIL";
	public static final String SUCCESS = "SUCCESS";
	public static final String RESP_MISSING_PARAMS = "0014";
	
	//Booking Statuses
	public static Integer PEND_APPROVE = 1;
	public static Integer BOOKED = 2;
	public static Integer CANCELLED_BYPATIENT = 3;
	public static Integer CANCELLED_BYDOCTOR = 4;
	public static Integer VISITIED = 5;
	public static Integer NOT_VISITED = 6;

}
