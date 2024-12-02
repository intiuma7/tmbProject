package com.tmb.exceptions;

@SuppressWarnings("serial")
public class ExcelPathNotFoundException extends FrameworkExceptions{
	
	public ExcelPathNotFoundException(String message)
	{
		super(message);
	}
	
	public ExcelPathNotFoundException(String message,Throwable cause)
	{
		super(message,cause);
	}
}
