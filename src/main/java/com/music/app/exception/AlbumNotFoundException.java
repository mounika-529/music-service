package com.music.app.exception;

public class AlbumNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1611363701142828596L;
	
	public AlbumNotFoundException(String message) {
		super(message);
	}

}
