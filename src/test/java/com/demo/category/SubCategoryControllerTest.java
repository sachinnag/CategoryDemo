package com.demo.category;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.category.entity.Category;

@TestMethodOrder(OrderAnnotation.class)
public class SubCategoryControllerTest extends AbstractTest {
	
	@Test
	@Order(1)
	public void getAllCategory() throws Exception {
		
		String uri = "/api/categories/subcategories";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
								 .get(uri)
								 .accept(MediaType.APPLICATION_JSON))
								 .andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		List<Category> categories = super.mapFromJson(content, List.class);
		assertTrue(categories.size() > 0);
	}
	
	@Test
	@Order(2)
	public void getCategory() throws Exception {
		
		String subCategoryId = "1052";
		String uri = "/api/categories/subcategories/" + subCategoryId;
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
								 .get(uri)
								 .accept(MediaType.APPLICATION_JSON))
								 .andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		Category category = super.mapFromJson(content, Category.class);
		assertNotNull(category);
	}
	
	@Test
	@Order(3)
	public void createCategory() throws Exception {
		
		String categoryId = "108";
		String uri = "/api/categories/" + categoryId + "/subcategories";
		
		String createJson = "{\r\n"
				+ "			\"name\":\"Mobile App Develoop\"\r\n"
				+ "		}";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
								 .post(uri)
								 .content(createJson)
								 .contentType(MediaType.APPLICATION_JSON)
								 .accept(MediaType.APPLICATION_JSON))
								 .andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(201, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		Category category = super.mapFromJson(content, Category.class);
		assertNotNull(category);
	}
	
	@Test
	@Order(4)
	public void updateCategory() throws Exception {
		
		String subCategoryId = "106";
		String uri = "/api/categories/subcategories/" + subCategoryId;
		
		String updateJson = "{\r\n"
				+ "	\"name\":\"Data Storage and Management\"\r\n"
				+ "}";
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
								 .put(uri)
								 .content(updateJson)
								 .contentType(MediaType.APPLICATION_JSON)
								 .accept(MediaType.APPLICATION_JSON))
								 .andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		Category category = super.mapFromJson(content, Category.class);
		assertNotNull(category);
	}
	
	@Test
	@Order(5)
	public void deleteCategory() throws Exception {
		
		String subCategoryId = "106";
		String uri = "/api/categories/subcategories/" + subCategoryId;
		
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders
								 .delete(uri)
								 .accept(MediaType.APPLICATION_JSON))
								 .andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
		String content = mvcResult.getResponse().getContentAsString();
		Category category = super.mapFromJson(content, Category.class);
		assertNotNull(category);
	}
	
}
