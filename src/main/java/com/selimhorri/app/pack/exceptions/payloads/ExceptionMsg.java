package com.selimhorri.app.pack.exceptions.payloads;

import java.io.Serializable;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;

public final class ExceptionMsg implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private final String msg;
	private final HttpStatus httpStatus;
	
	@JsonIgnore
	private final Throwable cause;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	@JsonDeserialize(using = InstantDeserializer.class)
	private final ZonedDateTime dateTime;
	
	public ExceptionMsg(final String msg, final HttpStatus httpStatus, final Throwable cause, final ZonedDateTime dateTime) {
		super();
		this.msg = msg;
		this.httpStatus = httpStatus;
		this.cause = cause;
		this.dateTime = dateTime;
	}
	
	@Override
	public String toString() {
		return "ExceptionMsg [msg=" + msg + ", cause=" + cause + ", httpStatus=" + httpStatus + ", dateTime=" + dateTime
				+ "]";
	}
	
	public Throwable getCause() {
		return cause;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	public ZonedDateTime getDateTime() {
		return dateTime;
	}
	
	
	
}









