package com.revature.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class PictureService {

	// Credentials of S3 Buckets
	private AWSCredentials credentials = new BasicAWSCredentials("AKIAIPUALAJFL5YXAQTA",
			"cWAlPG1Hm5cQkiFQTZgPDOS0qmETJ86K8UEeiv6N");

	private AmazonS3 s3client = AmazonS3ClientBuilder.standard()
			.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_2).build();

	// Retrieves file from S3 bucket -- needs to be processed to be sent to client
	public S3Object getImageFromS3Bucket(String fileName) {
		return s3client.getObject(new GetObjectRequest("whiteboard-test", fileName));
	}
	
	// Places image onto the S3 bucket -- need to process the received image into a File.class
	public void putImageOntoS3Bucket(String fileName, InputStream in) {

		File outputfile = new File("image.jpg");
//		ImageIO.write(image, "png", outputfile);

		s3client.putObject("whiteboard-test", fileName, outputfile);
	}
}
