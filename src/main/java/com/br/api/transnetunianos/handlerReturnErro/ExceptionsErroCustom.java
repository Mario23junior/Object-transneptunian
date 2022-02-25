package com.br.api.transnetunianos.handlerReturnErro;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExceptionsErroCustom {
   
	private int status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date timestmap;
	private String message;
	private String path;

	public ExceptionsErroCustom(int status, Date timestmap, String message, String path) {
		super();
		this.status = status;
		this.timestmap = timestmap;
		this.message = message;
		this.path = path;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getTimestmap() {
		return timestmap;
	}

	public void setTimestmap(Date timestmap) {
		this.timestmap = timestmap;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
