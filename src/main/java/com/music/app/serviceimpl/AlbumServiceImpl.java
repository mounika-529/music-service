package com.music.app.serviceimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.music.app.domain.Album;
import com.music.app.domain.Artist;
import com.music.app.exception.AlbumNotFoundException;
import com.music.app.repository.AlbumRepository;
import com.music.app.service.AlbumService;

/**
 * The Class AlbumServiceImpl.
 */
@Service
public class AlbumServiceImpl implements AlbumService {

	/** The album repository. */
	@Autowired
	private AlbumRepository albumRepository;

	/**
	 * Find all albums.
	 *
	 * @return the sets the
	 */
	@Override
	public Set<Album> findAllAlbums(int pageNo, int pageSize, String sortByOrder) {
		Pageable paging = null;
		if (sortByOrder.equalsIgnoreCase("DESC")) {
			paging = PageRequest.of(pageNo, pageSize, Sort.by("albumTitle").descending());
		} else {			
			paging = PageRequest.of(pageNo, pageSize, Sort.by("albumTitle").ascending());
		}

		Page<Album> pagedResult = albumRepository.findAll(paging);

		if (!pagedResult.hasContent()) 
			 throw new AlbumNotFoundException("There are no Albums in the storage ");
			
		return new HashSet<Album>(pagedResult.getContent());
	}

	/**
	 * Find album by id.
	 *
	 * @param albumId the album id
	 * @return the album
	 */

	@Override
	public Album findAlbumById(String albumId) {
		System.out.println("albumId------>" + albumId);
		Optional<Album> albumOptional = albumRepository.findById(albumId);				
		if (!albumOptional.isPresent())
		      throw new AlbumNotFoundException("AlbumId is not found -  " + albumId);
		
		return albumOptional.get();
	}

	/**
	 * Update album.
	 *
	 * @param album the album
	 */
	@Override
	public void updateAlbum(Album album) {
		albumRepository.saveAndFlush(album);
	}

	/**
	 * Find album by artist id.
	 *
	 * @param artistId the artist id
	 * @return the list
	 */
	@Override
	public List<Album> findAlbumByArtistId(String artistId) {

		Artist artist = new Artist();
		artist.setArtistId(artistId);

		Sort sort = Sort.by("albumTitle");
		List<Album> albumList = albumRepository.findByArtist(artist, sort);
		if(albumList==null || albumList.isEmpty()) 
			throw new AlbumNotFoundException("No Albums found for ArtistId -  " + artistId);
			      
		return albumList;
	}

	@Override
	public List<Album> findAlbumByGenre(String genre) {

		Sort sort = Sort.by("albumTitle");
		List<Album> albumList = albumRepository.findByGenres(genre, sort);
		if(albumList==null || albumList.isEmpty()) 
			throw new AlbumNotFoundException("No Albums found for Genre -  " + genre);

		return albumList;
	}

}
