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

import com.beans.Patient;
import com.beans.Response;
import com.beans.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UsersClient {
	public static void main(String[] args) {
		Users usr = new Users();
		usr.setEmailId("a@e.com");
		usr.setUserTyp("DOCTOR");
		usr.setOtp("123456");

		UsersClient uc = new UsersClient();
		uc.addUser(usr);
	}

	public Response deletePatient(Long patientId) {

		HttpClient client = HttpClientBuilder.create().build();
		try {
			String url = "http://localhost:8080/LabApi/api/patient/delete?patientId="
					+ patientId;
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
	public Response activatepatient(Long patientId) {

		HttpClient client = HttpClientBuilder.create().build();
		try {
			String url = "http://localhost:8080/LabApi/api/patient/activatepatient?patientId="
					+ patientId;
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

	public Response updatePatient(Patient ptnt) {

		HttpClient client = HttpClientBuilder.create().build();
		try {
			String url = "http://localhost:8080/LabApi/api/patient/update";
			HttpResponse response;
			final HttpClientContext context = HttpClientContext.create();
			HttpPost request = new HttpPost(url);
			String requestxml = null;
			StringWriter sw = new StringWriter();
			JAXBContext jaxbContext = JAXBContext.newInstance(Patient.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(ptnt, sw);
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
	public Patient getPatient(Long PatientId) {

		HttpClient client = HttpClientBuilder.create().build();
		try {

			HttpGet getRequest = new HttpGet(
					"http://localhost:8080/LabApi/api/patient/get?patientId="
							+ PatientId.longValue());

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

			JAXBContext jaxbContext = JAXBContext.newInstance(Patient.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Patient ptnt = (Patient) jaxbUnmarshaller
					.unmarshal(new StringReader(apiOutput));

			System.out.println(ptnt.getPatientId());
			System.out.println(ptnt.getEmailID());
			return ptnt;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} finally {
			client.getConnectionManager().shutdown();
		}

	}

	public Patient addUser(Users user) {

		HttpClient client = HttpClientBuilder.create().build();
		try {
			String url = "http://localhost:8080/LabApi/api/patient/add";
			HttpResponse response;
			final HttpClientContext context = HttpClientContext.create();
			HttpPost request = new HttpPost(url);
			String requestxml = null;
			StringWriter sw = new StringWriter();
		

			GsonBuilder gb = new GsonBuilder();
			Gson create = gb.create();

			String json = create.toJson(user, Users.class);

			System.out.println("NEW Request JSON = " + json);
			StringEntity se = new StringEntity(json.toString());
			se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
					"application/json"));
			se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE,
					"application/json"));
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
