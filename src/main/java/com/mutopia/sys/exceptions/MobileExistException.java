/**
 * <p>Title: MobileExistException</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.exceptions;

public class MobileExistException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MobileExistException(String mobile) {
        super(mobile+" is already exist!");
    }

}
