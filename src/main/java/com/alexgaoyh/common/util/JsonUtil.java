package com.alexgaoyh.common.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;

public class JsonUtil {

	public static String object2String(Object data) throws IOException {
		ObjectMapper om = new ObjectMapper();
		SimpleFilterProvider filterProvider = new SimpleFilterProvider().setFailOnUnknownId(false);
		om.setFilters(filterProvider);
		return om.writeValueAsString(data);
	}
}
