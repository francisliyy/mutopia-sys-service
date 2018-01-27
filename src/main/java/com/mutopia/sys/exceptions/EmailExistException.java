/**
 * <p>Title: EmailExistException</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.exceptions;

public class EmailExistException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailExistException(String email) {
        super(email+" is already exist!");
    }

}
