package com.music.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.music.app.domain.Album;
import com.music.app.domain.Artist;
import com.music.app.service.AlbumService;
import com.music.app.service.ArtistService;


/**
 * The Class ArtistController.
 */
@RestController
@RequestMapping("/artist")
public class ArtistController {
	
	/** The artist service impl. */
	@Autowired
	private ArtistService artistServiceImpl;

	/** The album service. */
	@Autowired
	private AlbumService albumService;

	/**
	 * Creates the artist.
	 *
	 * @param artist the artist
	 */
	@PostMapping("/create")
	@ResponseBody
	public void createArtist(@Validated @RequestBody Artist artist) {
		 artistServiceImpl.createArtist(artist);
		
	}

	/**
	 * Update artist.
	 *
	 * @param artist the artist
	 */
	@PutMapping("/update")
	public void updateArtist(@RequestBody Artist artist) {
		artistServiceImpl.updateArtist(artist);
	}

	/**
	 * Find artist by id.
	 *
	 * @param artistId the artist id
	 * @return the artist
	 */
	@GetMapping("/findByArtistId/{artistId}")
	public Artist findArtistById(@PathVariable String artistId) {
		Artist artist = artistServiceImpl.findArtistById(artistId);		
		return artist;
	}
	
	@GetMapping("/findByArtistName/{artistName}")
	public  Artist findArtistByName(@PathVariable String artistName) {		 
		return artistServiceImpl.findArtistByName(artistName); 
	}

	/**
	 * Find all artists.
	 *
	 * @return the list
	 */
	@GetMapping("/findAllArtists")
	public List<Artist> findAllArtists(@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam String sortByOrder) {
		List<Artist> artistList = artistServiceImpl.findAllArtists(pageNo, pageSize, sortByOrder);
		return artistList;
	}

	
	/**
	 * Find albums by artist id.
	 *
	 * @param artistId the artist id
	 * @return the list
	 */
	@GetMapping("/{artistId}/albums")
	public List<Album> findAlbumsByArtistId(@PathVariable String artistId) {
		List<Album> albumList = albumService.findAlbumByArtistId(artistId);
		return albumList;
	}
	

}
