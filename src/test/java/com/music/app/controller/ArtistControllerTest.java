package com.music.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.music.app.domain.Album;
import com.music.app.domain.Artist;
import com.music.app.domain.Track;
import com.music.app.service.AlbumService;
import com.music.app.service.ArtistService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ArtistController.class)
public class ArtistControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ArtistService artistService;

	@MockBean
	private AlbumService albumService;

	Artist mockArtist = new Artist("ART100", "Ram Charan", Arrays.asList(
			new Album("ALB200", "Master", "2020-06-24", "Melody", Arrays.asList(new Track(300, "digital track1")))));

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	protected <T> T mapFromJson(String json, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(json, clazz);
	}

	@Test
	public void testCreateArtist() throws Exception {		
			
		String inputJson = mapToJson(mockArtist);
		   MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/artist/create")
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		   
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   //String content = mvcResult.getResponse().getContentAsString();
		  // assertEquals(content, "Product is created successfully");

	}
	
	@Test
	public void testUpdateArtist() throws Exception {		
			
		String inputJson = mapToJson(mockArtist);
		   MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put("/artist/update")
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		   
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   //String content = mvcResult.getResponse().getContentAsString();
		  // assertEquals(content, "Product is created successfully");

	}
	
	@Test
	public void testFindByArtistId() throws Exception {	
		
	}
	
	@Test
	public void testFindAllArtists() throws Exception {	
			   
		String uri = "/artist/findAllArtists?pageNo=0&pageSize=10&sortByOrder=ASC";
		   MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
		      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		   
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   String content = mvcResult.getResponse().getContentAsString();
		   Artist[] artists = mapFromJson(content, Artist[].class);
		  // assertTrue(artists.length > 0);
		
	}
}
