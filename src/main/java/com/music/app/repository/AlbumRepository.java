package com.music.app.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.music.app.domain.Album;
import com.music.app.domain.Artist;


/**
 * The Interface AlbumRepository.
 */
public interface AlbumRepository extends JpaRepository<Album, String> {
	
	/**
	 * Find by artist.
	 *
	 * @param artist the artist
	 * @return the list
	 */
	public List<Album> findByArtist(Artist artist, Sort sort);
	
	public List<Album> findByGenres(String genres, Sort sort);

}
