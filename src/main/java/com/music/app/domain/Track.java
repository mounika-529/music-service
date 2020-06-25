package com.music.app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The Class Track.
 */
@Entity
@Table(name = "track")
public class Track {
	
	/** The track id. */
	@Id
	private int trackId;

	/** The title. */
	private String title;

	/** The album. */
	@JsonBackReference("album-track")
	@ManyToOne
	@JoinColumn(name = "album_id")
	private Album album;

	/**
	 * Instantiates a new track.
	 */
	public Track() {
		super();
	}

	/**
	 * Instantiates a new track.
	 *
	 * @param trackId the track id
	 * @param title the title
	 * @param album the album
	 */
	public Track(int trackId, String title, Album album) {
		super();
		this.trackId = trackId;
		this.title = title;
		this.album = album;
	}

	public Track(int trackId, String title) {
		super();
		this.trackId = trackId;
		this.title = title;
	}

	/**
	 * Gets the track id.
	 *
	 * @return the track id
	 */
	public int getTrackId() {
		return trackId;
	}

	/**
	 * Sets the track id.
	 *
	 * @param trackId the new track id
	 */
	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the album.
	 *
	 * @return the album
	 */
	public Album getAlbum() {
		return album;
	}

	/**
	 * Sets the album.
	 *
	 * @param album the new album
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}

}
