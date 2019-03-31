package com.revature.services;

<<<<<<< HEAD
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
=======
import java.util.HashMap;
import java.util.Map;
>>>>>>> 84fc4a19d8f0240e15b8bdf7c7a901754be61324

import org.springframework.stereotype.Service;

import com.revature.util.ImageUtil;

@Service
public class ImageService {

<<<<<<< HEAD
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
=======
	public Map<String, String> uploadImageToS3(String name, String image) {
		Map<String, String> jsonMap = new HashMap<>();
		if(ImageUtil.putImageOntoS3Bucket(name + ".png", image)) {
			jsonMap.put("uploadStatus", "success");
		}else {
			jsonMap.put("uploadStatus", "failure");
		}
		return jsonMap;
	}

	public Map<String, String> retrieveImageFromS3(String name) {
		return ImageUtil.convertS3ObjectToJson(ImageUtil.getImageFromS3Bucket(name));
>>>>>>> 84fc4a19d8f0240e15b8bdf7c7a901754be61324
	}
}
