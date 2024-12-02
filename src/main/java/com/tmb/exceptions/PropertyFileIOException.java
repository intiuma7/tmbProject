package com.tmb.exceptions;

@SuppressWarnings("serial")
public class PropertyFileIOException extends FrameworkExceptions{

	public PropertyFileIOException(String message) {
		super(message);

	}
	
	public PropertyFileIOException(String message,Throwable e) {
		super(message,e);

	}

}
