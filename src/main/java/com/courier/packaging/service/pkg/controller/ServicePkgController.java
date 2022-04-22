package com.courier.packaging.service.pkg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.courier.packaging.service.pkg.model.request.ItemAddress;
import com.courier.packaging.service.pkg.service.ServicePkgService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ServicePkgController {
	
	@Autowired
	ServicePkgService servicePkgService;
	
	@PostMapping(value = "/sort", produces = { MediaType.APPLICATION_JSON_VALUE })
	@Operation(summary = "packaging of courier items", description = "packaging of courier items")
	public boolean sortPackage(
			@Parameter(required = true, description = "Splits items by address/zone that is preconfigured") @RequestBody List<ItemAddress> lstItemAddress) throws Exception {
		log.debug("Request accepted in Service Package");
		boolean callSorting = servicePkgService.messageToServiceDelivery(lstItemAddress);
		return callSorting;
	}

}
