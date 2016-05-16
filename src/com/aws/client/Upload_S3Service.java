package com.aws.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;

public class Upload_S3Service {

	public static void main(String[] args) throws IOException {
		Upload_S3Service us = new Upload_S3Service();
		byte[] contents = new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

		String keyName = "hello";
		us.upload_s3File(contents, keyName); 
	}
 
	void upload_s3File(byte[] contents, String keyName) {
		String bucketName = Configuration.getInstance("server").getProperty(
				"s3_bucket_name");
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(Configuration
				.getInstance("server").getProperty("aws_access_key_id"),
				Configuration.getInstance("server").getProperty(
						"aws_secret_access_key"));
		AmazonS3 s3client = new AmazonS3Client(awsCreds);

		try {
			System.out.println("Uploading a new object to S3 from a file\n");

			InputStream stream = new ByteArrayInputStream(contents);
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentLength(contents.length);
			meta.setContentType("application/text");
			s3client.putObject(bucketName, keyName, stream, meta);

		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which "
					+ "means your request made it "
					+ "to Amazon S3, but was rejected with an error response"
					+ " for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which "
					+ "means the client encountered "
					+ "an internal error while trying to "
					+ "communicate with S3, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
		}
	}

}
