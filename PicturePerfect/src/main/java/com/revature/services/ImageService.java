package com.revature.services;

import java.io.File;
import java.io.IOException;
import java.sql.Blob;

import org.springframework.stereotype.Service;

import com.revature.util.ImageUtil;

@Service
public class ImageService {

	public Blob uploadBlobToS3(Blob blob) {

		return blob;
	}

	public File retrieveBlobFromS3(String name) {
		
		File file = null;
		try {
			file = ImageUtil.convertS3ObjectToFile(ImageUtil.getImageFromS3Bucket(name));
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return file;
	}
}
