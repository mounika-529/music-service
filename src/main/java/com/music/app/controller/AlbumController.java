package com.music.app.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.music.app.domain.Album;
import com.music.app.service.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {
	
	/** The album service. */
	@Autowired
	private AlbumService albumService;
	
	/**
	 * Find album by id.
	 *
	 * @param albumId the album id
	 * @return the album
	 */
	@GetMapping("/findByAlbumId/{albumId}")
	public Album findAlbumById(@PathVariable String albumId) {
		Album album = albumService.findAlbumById(albumId);
		return album;
	}
		
	/**
	 * Find all albums.
	 *
	 * @return the sets the
	 */
	@GetMapping("/findAllAlbums")
	public Set<Album> findAllAlbums(@RequestParam int pageNo, @RequestParam int pageSize, @RequestParam String sortByOrder) {
		Set<Album> albumSet = albumService.findAllAlbums(pageNo, pageSize, sortByOrder);
		return albumSet;
	}

	@GetMapping("/findByGenre/{genre}")
	public List<Album> findAlbumByGenre(@PathVariable String genre) {
		List<Album> albumList = albumService.findAlbumByGenre(genre);
		return albumList;
	}

}
