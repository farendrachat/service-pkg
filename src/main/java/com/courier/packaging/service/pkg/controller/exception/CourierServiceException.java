package com.courier.packaging.service.pkg.controller.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CourierServiceException extends Exception{

	private static final long serialVersionUID = 1L;

	public CourierServiceException(String errMsg){
		super(errMsg);
        log.debug("Exception in service pkg is: "+errMsg);
	}
}