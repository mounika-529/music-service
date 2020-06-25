package com.music.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.music.app.domain.Artist;

/**
 * The Interface ArtistRepository.
 */
@Repository
public interface ArtistRepository  extends JpaRepository<Artist,String> {
	
	public Artist findByArtistName(String artistName);

}
