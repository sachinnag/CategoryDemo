package com.demo.category;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.category.rest.CategoryController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class AbstractTest {

	@Autowired
	protected MockMvc mvc;
		
   protected String mapToJson(Object obj) throws JsonProcessingException {
	   ObjectMapper objectMapper = new ObjectMapper();
	   return objectMapper.writeValueAsString(obj);
   }
   
   protected <T> T mapFromJson(String json, Class<T> clazz)
		   throws JsonParseException, JsonMappingException, IOException {
      
	   ObjectMapper objectMapper = new ObjectMapper();
	   return objectMapper.readValue(json, clazz);
   }
	
}
