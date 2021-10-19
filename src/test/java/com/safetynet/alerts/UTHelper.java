package com.safetynet.alerts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UTHelper {
	private static ObjectMapper mapper = new ObjectMapper();

	public UTHelper(){
	}

	public static String readFileAsString(String fileRelativePath) throws IOException{
		String basePath = "src/test/resources";
		File file = new File(basePath + "/" + fileRelativePath);
		return FileUtils.readFileToString(file, StandardCharsets.UTF_8);
	}

	public static <T> T stringToObject(String objectString, Class<T> objectClass) throws JsonProcessingException{
		mapper.registerModule(new JavaTimeModule());
		return mapper.readValue(objectString, objectClass);
	}
}
