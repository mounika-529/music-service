/*
 * Author Lamxi
 */
package com.music.app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The Class Artist.
 */
@Entity
@Table(name = "artist")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "artistId")
public class Artist {
	
	/** The artist id. */
	@Id
	private String artistId;

	/** The artist name. */
	private String artistName;

	/** The album list. */
	@JsonManagedReference("artist-album")
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Album> albumList = new ArrayList<>();

	/**
	 * Instantiates a new artist.
	 */
	public Artist() {
		super();
	}

	
	public Artist(String artistId, String artistName, List<Album> albumList) {
		super();
		this.artistId = artistId;
		this.artistName = artistName;
		this.albumList = albumList;
	}

	/**
	 * Gets the artist id.
	 *
	 * @return the artist id
	 */
	public String getArtistId() {
		return artistId;
	}

	/**
	 * Sets the artist id.
	 *
	 * @param artistId the new artist id
	 */
	public void setArtistId(String artistId) {
		this.artistId = artistId;
	}

	/**
	 * Gets the artist name.
	 *
	 * @return the artist name
	 */
	public String getArtistName() {
		return artistName;
	}

	/**
	 * Sets the artist name.
	 *
	 * @param artistName the new artist name
	 */
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	/**
	 * Gets the album list.
	 *
	 * @return the album list
	 */
	public List<Album> getAlbumList() {
		return albumList;
	}

	/**
	 * Sets the album list.
	 *
	 * @param albumList the new album list
	 */
	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}

		
}
