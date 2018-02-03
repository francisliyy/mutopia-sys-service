/**
 * <p>Title: ExceptionHandlingController</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>Company: MUTOPIA</p>
 * @author lyx
 * @version 1.0
 */
package com.mutopia.sys.controller.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mutopia.sys.exceptions.EmailExistException;
import com.mutopia.sys.exceptions.SysMgtException;
import com.mutopia.sys.model.exception.ExceptionResponse;
import com.mutopia.sys.utils.ValidationUtil;

@ControllerAdvice
public class ExceptionHandlingController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> invalidInput(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("Validation Error");
        response.setErrorMessage("Invalid inputs.");
        response.setErrors(ValidationUtil.fromBindingErrors(result));
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(EmailExistException.class)
    public ResponseEntity<ExceptionResponse> userExist(EmailExistException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("Validation Error");
        response.setErrorMessage("Mailbox exists.");
        List<String> errors = new ArrayList<String>();
        errors.add(ex.getMessage());
        response.setErrors(errors);
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
    }
	
	@ExceptionHandler(SysMgtException.class)
    public ResponseEntity<ExceptionResponse> invalidInput(SysMgtException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setErrorCode("SysMgt Error");
        response.setErrorMessage(ex.getLocalizedMessage());
        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
    }
	
}
