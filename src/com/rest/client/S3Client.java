package com.rest.client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import com.beans.Constants;
import com.beans.Images;
import com.beans.Patient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class S3Client {
	public static void main(String[] args) {
		S3Client sc = new S3Client();
		Images s3img = new Images();

		try {
			InputStream is = new FileInputStream("/Users/nikhil/Query.txt");

			byte[] bytes = IOUtils.toByteArray(is);
			s3img.setImage(bytes);
			s3img.setImgname("Query66799738.txt");
			s3img.setImgTyp("profile");
			s3img.setEntityId(10L);
			s3img.setEntityTyp(Constants.LAB_OFFICE);
			sc.upload_s3(s3img);
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * s3img.setImg_name("Query.txt"); s3img.setImg_type("profile");
		 * s3img.setUser_type(Constants.LAB_OFFICE); String img_name =
		 * "Query1.txt";
		 * 
		 * 
		 * if (s3img.getUser_type().equalsIgnoreCase(Constants.DOCTOR)) {
		 * img_name = Constants.DOCTOR + "/" + s3img.getImg_type() + "/" +
		 * s3img.getImg_name(); } if
		 * (s3img.getUser_type().equalsIgnoreCase(Constants.LAB_BRANCH)) {
		 * img_name = Constants.LAB_BRANCH + "/" + s3img.getImg_type() + "/" +
		 * s3img.getImg_name(); } if
		 * (s3img.getUser_type().equalsIgnoreCase(Constants.LAB_OFFICE)) {
		 * img_name = Constants.LAB_OFFICE + "/" + s3img.getImg_type() + "/" +
		 * s3img.getImg_name(); } if
		 * (s3img.getUser_type().equalsIgnoreCase(Constants.PATIENT)) { img_name
		 * = Constants.PATIENT + "/" + s3img.getImg_type() + "/" +
		 * s3img.getImg_name(); }
		 * 
		 * s3img = sc.download_s3(img_name); try { FileOutputStream fos = new
		 * FileOutputStream( "/Users/nikhil/Query1.txt");
		 * fos.write(s3img.getImage()); fos.close(); } catch (Exception e) {
		 * 
		 * }
		 */

	}

	public Images download_s3(String img_name) {

		HttpClient client = HttpClientBuilder.create().build();
		try {
			String url = "http://localhost:8080/LabApi/api/common/download_s3?img_name="
					+ img_name;
			System.out.println("download_s3 URL " + url);
			HttpResponse response;
			final HttpClientContext context = HttpClientContext.create();
			HttpGet request = new HttpGet(url);

			response = client.execute(request, context);

			System.out.println("Response Code "
					+ response.getStatusLine().getStatusCode());
			if (200 != response.getStatusLine().getStatusCode()) {
				System.out.println("Sisense call failed Response Code="
						+ response.getStatusLine().getStatusCode());
				throw new Exception("Sisense call failed");
			}
			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
				System.out.println("result : " + line);

			}
			JAXBContext jc = JAXBContext.newInstance(Images.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			StreamSource streamSource = new StreamSource(new StringReader(
					result.toString()));

			JAXBElement<Images> je = unmarshaller.unmarshal(streamSource,
					Images.class);
			return je.getValue();
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} finally {
			client.getConnectionManager().shutdown();
		}

	}

	public Patient upload_s3(Images s3img) {

		HttpClient client = HttpClientBuilder.create().build();
		try {
			String url = "http://localhost:8080/LabApi/api/image/add";
			HttpResponse response;
			final HttpClientContext context = HttpClientContext.create();
			HttpPost request = new HttpPost(url);

			GsonBuilder gb = new GsonBuilder();

			Gson create = gb.create();

			String json = create.toJson(s3img, Images.class);

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
