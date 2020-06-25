package com.music.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.music.app.domain.Album;
import com.music.app.domain.Artist;
import com.music.app.domain.Track;
import com.music.app.repository.ArtistRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArtistRepositoryTest{

	@Autowired
	private ArtistRepository artistRepository;

	@Test
	public void test_createArtist() {
		Track track = new Track(300, "digital track1");
		List<Track> trackList = new ArrayList<>();
		trackList.add(track);

		Album album = new Album("ALB200", "Master", "2020-06-24", "Melody", trackList);
		List<Album> albumList = new ArrayList<Album>();
		albumList.add(album);

		Artist artist = new Artist("ART100", "Ram Charan", albumList);
		artistRepository.save(artist);
		assertNotNull(artist);
		Artist testArtist = artistRepository.findById("ART100").get();
		assertEquals(testArtist.getArtistId(), artist.getArtistId());
		assertEquals(testArtist.getArtistName(), artist.getArtistName());
	}

	@Test
	public void testFindArtistById() {
		Artist artist = new Artist("ART100", "Ram Charan", new ArrayList<Album>());
		artistRepository.save(artist);
		assertNotNull(artist);
		Artist testArtist = artistRepository.findById("ART100").get();
		assertEquals(testArtist.getArtistId(), artist.getArtistId());		
	}
	@Test
	public void testFindByArtistName() {
		Artist artist = new Artist("ART100", "Ram Charan", new ArrayList<Album>());
		artistRepository.save(artist);
		assertNotNull(artist);
		Artist testArtist = artistRepository.findByArtistName("Ram Charan");
		assertEquals(testArtist.getArtistName(), artist.getArtistName());		
	}
	
	@Test
	public void testFindAllArtists() {
		Artist artist = new Artist("ART100", "Ram Charan", new ArrayList<Album>());
		artistRepository.save(artist);
		assertNotNull(artist);
		List<Artist> artistList = artistRepository.findAll();
		assertEquals(1, artistList.size());		
	}
	
	
}

