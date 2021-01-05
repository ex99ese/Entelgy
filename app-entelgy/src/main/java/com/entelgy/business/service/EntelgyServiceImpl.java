package com.entelgy.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entelgy.business.dto.JsonentelgyResponse;
import com.entelgy.business.mapper.JsonentelgyMapper;
import com.entelgy.business.proxy.ClientProxy;

import reactor.core.publisher.Mono;

@Service
public class EntelgyServiceImpl implements EntelgyService {
	
	@Autowired
	private ClientProxy proxy;
	
	@Autowired
	private JsonentelgyMapper mapper;

	@Override
	public Mono<JsonentelgyResponse> getJsonplaceholderList() {
		return   Mono.just(
				mapper.buildJsonentelgyResponse(proxy.getList()));
	}

}
