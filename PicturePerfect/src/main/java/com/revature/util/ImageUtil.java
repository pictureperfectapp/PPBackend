package com.revature.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class ImageUtil {

	// Gives access to AWS S3 services with region specificity
	private static AWSCredentials credentials = new BasicAWSCredentials(System.getenv("AWS_ACCESSKEY"),
			System.getenv("AWS_SECRETKEY"));

	private static AmazonS3 s3client = AmazonS3ClientBuilder.standard()
			.withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_EAST_2).build();

	public static S3Object getImageFromS3Bucket(String fileName) {
		// GetObjectRequest(bucketName, fileName)
		S3Object object = s3client.getObject(new GetObjectRequest("whiteboard-test", fileName));
		return object;
	}

	public static void putImageOntoS3Bucket(String fileName, File file){

//			int width = 963;
//			int height = 640;
//			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
//			try {
//				image = ImageIO.read(new File("C:\\\\Users\\\\Kevin\\\\Downloads\\\\Output2.png"));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			File outputfile = new File("image.jpg");
//			ImageIO.write(image, "png", outputfile);

		// putObject(bucketName, fileName, file)
		s3client.putObject("whiteboard-test", fileName, file);
	}
	public static File convertS3ObjectToFile(S3Object s3Object) throws IOException, InterruptedException {
//		S3Object s3 = getImageFromS3Bucket(fileName);
		File file = new File(s3Object.getKey() + ".png");
		InputStream in = s3Object.getObjectContent();
		int count;
		byte[] buf = new byte[1024];
		OutputStream out = new FileOutputStream(file);
		while ((count = in.read(buf)) != -1) {
			if (Thread.interrupted()) {
				out.close();
				in.close();
				throw new InterruptedException();
			}
			out.write(buf, 0, count);
		}
		out.close();
		in.close();
		return file;
	}
}
