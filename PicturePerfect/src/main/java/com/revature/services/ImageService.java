package com.revature.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.revature.util.ImageUtil;

@Service
public class ImageService {

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
	}
}
