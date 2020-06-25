package com.music.app.service;

import java.util.List;

import com.music.app.domain.Artist;


/**
 * The Interface ArtistService.
 */
public interface ArtistService {
	
	/**
	 * Creates the artist.
	 *
	 * @param artist the artist
	 */
	public void createArtist(Artist artist);
	
	/**
	 * Update artist.
	 *
	 * @param artist the artist
	 */
	public void updateArtist(Artist artist);

	/**
	 * Find artist by id.
	 *
	 * @param artistId the artist id
	 * @return the artist
	 */
	public Artist findArtistById(String artistId);

	/**
	 * Find all artists.
	 *
	 * @return the list
	 */
	public List<Artist> findAllArtists(int pageNo, int pageSize, String sortByOrder);	
	
	public Artist findArtistByName(String artistName);
	
}
