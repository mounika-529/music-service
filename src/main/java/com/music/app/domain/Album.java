package com.music.app.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * The Class Album.
 */
@Entity
@Table(name = "album")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "albumId")
public class Album {

	/** The album id. */
	@Id
	private String albumId;
	
	/** The album title. */
	private String albumTitle;
	
	/** The year of release. */
	private String yearOfRelease;
	
	/** The genres. */
	private String genres;
	// private String artistId;

	/** The artist. */
	@JsonBackReference("artist-album")
	@ManyToOne
	@JoinColumn(name = "artist_id")
	private Artist artist;

	/** The track list. */
	@JsonManagedReference("album-track")
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
	private List<Track> trackList = new ArrayList<>();

	/**
	 * Instantiates a new album.
	 */
	public Album() {
		super();
	}

	/**
	 * Instantiates a new album.
	 *
	 * @param albumId the album id
	 * @param albumTitle the album title
	 * @param yearOfRelease the year of release
	 * @param genres the genres
	 * @param artist the artist
	 * @param trackList the track list
	 */
	public Album(String albumId, String albumTitle, String yearOfRelease, String genres, Artist artist,
			List<Track> trackList) {
		super();
		this.albumId = albumId;
		this.albumTitle = albumTitle;
		this.yearOfRelease = yearOfRelease;
		this.genres = genres;
		this.artist = artist;
		this.trackList = trackList;
	}

	public Album(String albumId, String albumTitle, String yearOfRelease, String genres, List<Track> trackList) {
		super();
		this.albumId = albumId;
		this.albumTitle = albumTitle;
		this.yearOfRelease = yearOfRelease;
		this.genres = genres;
		this.trackList = trackList;
	}

	/**
	 * Gets the album id.
	 *
	 * @return the album id
	 */
	public String getAlbumId() {
		return albumId;
	}

	/**
	 * Sets the album id.
	 *
	 * @param albumId the new album id
	 */
	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	/**
	 * Gets the album title.
	 *
	 * @return the album title
	 */
	public String getAlbumTitle() {
		return albumTitle;
	}

	/**
	 * Sets the album title.
	 *
	 * @param albumTitle the new album title
	 */
	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	/**
	 * Gets the year of release.
	 *
	 * @return the year of release
	 */
	public String getYearOfRelease() {
		return yearOfRelease;
	}

	/**
	 * Sets the year of release.
	 *
	 * @param yearOfRelease the new year of release
	 */
	public void setYearOfRelease(String yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	/**
	 * Gets the genres.
	 *
	 * @return the genres
	 */
	public String getGenres() {
		return genres;
	}

	/**
	 * Sets the genres.
	 *
	 * @param genres the new genres
	 */
	public void setGenres(String genres) {
		this.genres = genres;
	}

	/**
	 * Gets the artist.
	 *
	 * @return the artist
	 */
	public Artist getArtist() {
		return artist;
	}

	/**
	 * Sets the artist.
	 *
	 * @param artist the new artist
	 */
	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	/**
	 * Gets the track list.
	 *
	 * @return the track list
	 */
	public List<Track> getTrackList() {
		return trackList;
	}

	/**
	 * Sets the track list.
	 *
	 * @param trackList the new track list
	 */
	public void setTrackList(List<Track> trackList) {
		this.trackList = trackList;
	}

}
