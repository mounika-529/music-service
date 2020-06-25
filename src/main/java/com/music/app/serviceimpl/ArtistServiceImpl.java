package com.music.app.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.music.app.controller.ArtistNotFoundException;
import com.music.app.domain.Artist;
import com.music.app.repository.ArtistRepository;
import com.music.app.service.ArtistService;

/**
 * The Class ArtistServiceImpl.
 */
@Service
public class ArtistServiceImpl implements ArtistService {

	/** The artist repository. */
	@Autowired
	private ArtistRepository artistRepository;

	/**
	 * Creates the artist.
	 *
	 * @param artist the artist
	 */
	@Override
	public void createArtist(Artist artist) {
		artistRepository.save(artist);

	}

	/**
	 * Find all artists.
	 *
	 * @return the list
	 */
	public List<Artist> findAllArtists(int pageNo, int pageSize, String sortByOrder) {
		Pageable paging = null;
		if (sortByOrder.equalsIgnoreCase("DESC")) {
			paging = PageRequest.of(pageNo, pageSize, Sort.by("artistName").descending());
		} else {
			paging = PageRequest.of(pageNo, pageSize, Sort.by("artistName").ascending());

		}

		Page<Artist> pagedResult = artistRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Artist>();
		}
	}

	/**
	 * Find artist by id.
	 *
	 * @param artistId the artist id
	 * @return the artist
	 */
	@Override
	public Artist findArtistById(String artistId) {
		return artistRepository.findById(artistId).get();
	}

	/**
	 * Update artist.
	 *
	 * @param artist the artist
	 */
	@Override
	public void updateArtist(Artist artist) {
		artistRepository.saveAndFlush(artist);

	}

	@Override
	public Artist findArtistByName(String artistName) {
		Artist artist = artistRepository.findByArtistName(artistName);
		return artist;
	}

}
