/**
 * <p>Title: ValidationUtil</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class ValidationUtil {

	public static List<String> fromBindingErrors(BindingResult result) {
		
		List<String> resultErrorList = new ArrayList<String>();
		for(ObjectError err : result.getAllErrors()){
			resultErrorList.add(err.getDefaultMessage());
		}
		
		return resultErrorList;
	}

}
