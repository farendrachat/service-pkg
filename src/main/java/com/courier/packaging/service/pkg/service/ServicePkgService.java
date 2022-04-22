package com.courier.packaging.service.pkg.service;


import java.util.List;

import com.courier.packaging.service.pkg.model.request.ItemAddress;

public interface ServicePkgService{
	boolean messageToServiceDelivery(List<ItemAddress> lstItemAddress) ;
}