/**
 * <p>Title: SysMgtException</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.exceptions;

public class SysMgtException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public SysMgtException() {
		this(" generate sysmgt exception!");
	}
	
	public SysMgtException(String msg) {
		super(msg);
	}
	
	public SysMgtException(String msg,Throwable cause){
		super(msg,cause);
	}

}
