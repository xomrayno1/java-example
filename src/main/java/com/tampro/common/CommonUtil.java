package com.tampro.common;

import java.io.File;
import java.nio.file.Files;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

public class CommonUtil {
	
	public static final String INDICES_CUSTOMER = "customer";
	
	private static final Logger LOG = LoggerFactory.getLogger(CommonUtil.class);

	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
	
	public static String loadAsString(final String path) {
		try {
			File file = new ClassPathResource(path).getFile();
			//return Files.readAllBytes(file.toPath()).toString(); sai
			return new String(Files.readAllBytes(file.toPath()));
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error("load file error {} ", e);
			return null;
		}
	}

}
