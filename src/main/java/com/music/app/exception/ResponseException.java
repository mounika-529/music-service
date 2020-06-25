package com.music.app.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ResponseException {

	private final String message;
	private final HttpStatus httpStatus;
	private final ZonedDateTime timestamp;
	private final Throwable reason;

	public ResponseException(String message, HttpStatus httpStatus, ZonedDateTime timestamp, Throwable reason) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.timestamp = timestamp;
		this.reason = reason;
	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public Throwable getReason() {
		return reason;
	}

}
