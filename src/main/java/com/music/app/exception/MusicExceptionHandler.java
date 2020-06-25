package com.music.app.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MusicExceptionHandler {
	
	@ExceptionHandler(value=ArtistNotFoundException.class)
	public ResponseEntity<ResponseException> artistNotFound(ArtistNotFoundException aex){
		ResponseException customerExceptionRespmse = 
				new ResponseException(aex.getMessage(),HttpStatus.NOT_FOUND,
						ZonedDateTime.now(ZoneId.of("Z")), aex.getCause());		
		return new ResponseEntity<ResponseException>(customerExceptionRespmse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value=AlbumNotFoundException.class)
	public ResponseEntity<ResponseException> albumNotFound(AlbumNotFoundException aex){
		ResponseException customerExceptionRespmse = 
				new ResponseException(aex.getMessage(),HttpStatus.NOT_FOUND,
						ZonedDateTime.now(ZoneId.of("Z")), aex.getCause());		
		return new ResponseEntity<ResponseException>(customerExceptionRespmse, HttpStatus.NOT_FOUND);
	}
	
}
