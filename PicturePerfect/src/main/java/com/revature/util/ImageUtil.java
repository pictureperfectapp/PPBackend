package com.revature.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class ImageUtil {

	
	/*To delete images: s3.deleteObject("bucket", "key"); */
	
	private ImageUtil() {
		super();
	}

	// Gives access to AWS S3 services with region specificity
	private static AWSCredentials credentials = new BasicAWSCredentials(System.getenv("AWS_ACCESSKEY"),
			System.getenv("AWS_SECRETKEY"));
	private static AmazonS3 s3client = AmazonS3ClientBuilder.standard()
			.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_2).build();

	//Uses AWS SDK to retrieve an image from a specific bucket -- whiteboard-test
	public static S3Object getImageFromS3Bucket(String fileName) {
		return s3client.getObject(new GetObjectRequest("whiteboard-test", fileName));
	}

	//Uses AWS SDK to upload an image to a specific bucket -- whiteboard-test
	public static boolean putImageOntoS3Bucket(String fileName, String image) {
		String base64Image = image.split(",")[1];
		byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
		ObjectMetadata meta = new ObjectMetadata();
		meta.setContentLength(imageBytes.length);
		PutObjectRequest s3Object = null;
		try (InputStream in = new ByteArrayInputStream(imageBytes);){
			s3Object = new PutObjectRequest("whiteboard-test", fileName, in, meta);
			s3client.putObject(s3Object);
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public static Map<String, String> convertS3ObjectToJson(S3Object s3Object) {
		int count;
		byte[] buf = new byte[1024];
		Map<String, String> jsonMap = new HashMap<>();
		
		try(InputStream in = s3Object.getObjectContent(); ByteArrayOutputStream out= new ByteArrayOutputStream();) {
			while ((count = in.read(buf)) != -1) {
				out.write(buf, 0, count);
			}
			String encodeImage = Base64.getEncoder().withoutPadding().encodeToString(out.toByteArray());
			jsonMap.put("content", encodeImage);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return jsonMap;
	}
	
}
