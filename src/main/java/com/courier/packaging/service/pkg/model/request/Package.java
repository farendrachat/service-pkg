package com.courier.packaging.service.pkg.model.request;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "Package", description = "package to club the items to be delivered to an address")
public class Package {
	
	@NotEmpty(message = "packageId can not be blank")
	@Schema(description ="unique packageId of the courier")
	private String packageId;	
	
	@Schema(description ="Unique address for courier")
	private Address address;
	
	@Schema(description ="List of items belonging to same address")
	private List<Item> lstItem;
	
}
