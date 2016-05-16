package com.rest.client;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.beans.Doctor;
import com.beans.Response;

public class LabBranchClient {
	public static void main(String[] args) {
		LabBranchClient pc = new LabBranchClient();
		Long DoctorId = 2L;
		Doctor pp = pc.getDoctor(DoctorId);
		System.out.println(pp.toString());

		
		  Doctor dd= new Doctor(); 
		  dd.setDoctorName("sdf");
		  pc.addDoctor(dd);
		 

		// Doctor pp = new Doctor();
		// pp.getDoctorAddress().setAddressId(38L);
		// pp.setDoctorId(17L);
		pp.setDoctorName("nghf");
		
		Response r=pc.updateDoctor(pp);
		System.out.println("Update Response "+ r);
		
		
		Response resp=pc.deleteDoctor(1L);
		System.out.println("Delete Response "+ resp);
		
		Response r2=pc.activateDoctor(2L);
		System.out.println("Activate Response "+ r2);

	}

	public Response deleteDoctor(Long DoctorId) {

		HttpClient client = HttpClientBuilder.create().build();
		try {
			String url = "http://localhost:8080/LabApi/api/doctor/delete?doctorId="
					+ DoctorId;
			HttpResponse response;
			final HttpClientContext context = HttpClientContext.create();
			HttpPost request = new HttpPost(url);

			response = client.execute(request, context);

			System.out.println("Response Code "
					+ response.getStatusLine().getStatusCode());
			HttpEntity httpEntity = response.getEntity();
			String apiOutput = EntityUtils.toString(httpEntity);

			JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Response resp = (Response) jaxbUnmarshaller
					.unmarshal(new StringReader(apiOutput));

			return resp;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
		return null;

	}
	public Response activateDoctor(Long DoctorId) {

		HttpClient client = HttpClientBuilder.create().build();
		try {
			String url = "http://localhost:8080/LabApi/api/doctor/activatedoctor?doctorId="
					+ DoctorId;
			HttpResponse response;
			final HttpClientContext context = HttpClientContext.create();
			HttpPost request = new HttpPost(url);

			response = client.execute(request, context);

			System.out.println("Response Code "
					+ response.getStatusLine().getStatusCode());
			HttpEntity httpEntity = response.getEntity();
			String apiOutput = EntityUtils.toString(httpEntity);

			JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Response resp = (Response) jaxbUnmarshaller
					.unmarshal(new StringReader(apiOutput));

			return resp;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
		return null;

	}

	public Response updateDoctor(Doctor doc) {

		HttpClient client = HttpClientBuilder.create().build();
		try {
			String url = "http://localhost:8080/LabApi/api/doctor/update";
			HttpResponse response;
			final HttpClientContext context = HttpClientContext.create();
			HttpPost request = new HttpPost(url);
			String requestxml = null;
			StringWriter sw = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(Doctor.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(doc, sw);
			requestxml = sw.toString();
			StringEntity se = new StringEntity(requestxml.toString());
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
					"application/xml"));
			se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,
					"application/xml"));
			request.setEntity(se);

			response = client.execute(request, context);

			System.out.println("Response Code "
					+ response.getStatusLine().getStatusCode());
			HttpEntity httpEntity = response.getEntity();
			String apiOutput = EntityUtils.toString(httpEntity);

			JAXBContext jaxbContext1 = JAXBContext.newInstance(Response.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext1.createUnmarshaller();
			Response resp = (Response) jaxbUnmarshaller
					.unmarshal(new StringReader(apiOutput));

			return resp;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
		return null;

	}

	// GET Call
	public Doctor getDoctor(Long DoctorId) {

		HttpClient client = HttpClientBuilder.create().build();
		try {

			HttpGet getRequest = new HttpGet(
					"http://localhost:8080/LabApi/api/doctor/get?doctorId="
							+ DoctorId.longValue());

			// Set the API media type in http accept header
			getRequest.addHeader("accept", "application/xml");
			HttpResponse response = client.execute(getRequest);

			// verify the valid error code first
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != 200) {
				throw new RuntimeException("Failed with HTTP error code : "
						+ statusCode);
			}

			// Now pull back the response object
			HttpEntity httpEntity = response.getEntity();
			String apiOutput = EntityUtils.toString(httpEntity);

			JAXBContext jaxbContext = JAXBContext.newInstance(Doctor.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Doctor doc = (Doctor) jaxbUnmarshaller
					.unmarshal(new StringReader(apiOutput));

			System.out.println(doc.getDocId());
			System.out.println(doc.getEmailID());
			return doc;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} finally {
			client.getConnectionManager().shutdown();
		}

	}

	public Doctor addDoctor(Doctor doc) {

		HttpClient client = HttpClientBuilder.create().build();
		try {
			String url = "http://localhost:8080/LabApi/api/doctor/add";
			HttpResponse response;
			final HttpClientContext context = HttpClientContext.create();
			HttpPost request = new HttpPost(url);
			String requestxml = null;
			StringWriter sw = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(Doctor.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(doc, sw);
			requestxml = sw.toString();
			StringEntity se = new StringEntity(requestxml.toString());
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
					"application/xml"));
			se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,
					"application/xml"));
			request.setEntity(se);

			response = client.execute(request, context);

			System.out.println("Response Code "
					+ response.getStatusLine().getStatusCode());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
		return null;

	}
}
