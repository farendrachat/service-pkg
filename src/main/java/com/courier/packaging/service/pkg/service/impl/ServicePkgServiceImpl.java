package com.courier.packaging.service.pkg.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Service;

import com.courier.packaging.service.pkg.entity.StateEntity;
import com.courier.packaging.service.pkg.model.request.ItemAddress;
import com.courier.packaging.service.pkg.repository.StateRepository;
import com.courier.packaging.service.pkg.service.ServicePkgService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("ServicePkgServiceImpl")
public class ServicePkgServiceImpl implements ServicePkgService {

	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;

	@Autowired
	private StateRepository stateRepository;

	@Value("${cloud.aws.region.endpoint.uri}")
	private String endPoint;

	public boolean messageToServiceDelivery(List<ItemAddress> lstItemAddress) {
		try {
			log.debug("Send item list over SQS message pipeline");
			queueMessagingTemplate.convertAndSend(endPoint, addZone(lstItemAddress));
		} catch (Exception ex) {
			log.debug("Exception caught in produceris :" + ex);
		}
		return true;
	}

	public List<ItemAddress> addZone(List<ItemAddress> lstItemAddress) {
		List<ItemAddress> lstItemAddressWithZone = new ArrayList();
		lstItemAddressWithZone.addAll(lstItemAddress);
		List<StateEntity> lstStateEntity = stateRepository.findAll();
		for (ItemAddress itemAddressTemp : lstItemAddress) {

			Optional<StateEntity> stateEntityTemp = lstStateEntity.stream()
					.filter(stateEntity -> stateEntity.getStateName().equals(itemAddressTemp.getState())).findAny();
			if (stateEntityTemp.isPresent()) {
				lstItemAddressWithZone.get(lstItemAddressWithZone.indexOf(itemAddressTemp))
						.setZone(stateEntityTemp.get().getStateZone());
			}
		}
		log.debug("Zone successfully added to states");
		return lstItemAddressWithZone;

	}
}