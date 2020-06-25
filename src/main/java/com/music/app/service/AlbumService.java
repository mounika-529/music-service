package com.music.app.service;

import java.util.List;
import java.util.Set;

import com.music.app.domain.Album;


/**
 * The Interface AlbumService.
 */
public interface AlbumService {

	/**
	 * Find all albums.
	 *
	 * @return the sets the
	 */
	public Set<Album> findAllAlbums(int pageNo, int pageSize, String sortByOrder);
	
	/**
	 * Find album by id.
	 *
	 * @param albumId the album id
	 * @return the album
	 */
	public Album findAlbumById(String albumId);
	
	/**
	 * Update album.
	 *
	 * @param album the album
	 */
	public void updateAlbum(Album album);
	
	/**
	 * Find album by artist id.
	 *
	 * @param artistId the artist id
	 * @return the list
	 */
	public List<Album> findAlbumByArtistId(String artistId);
	
	public List<Album> findAlbumByGenre(String genre);
}
