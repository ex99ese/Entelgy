package com.entelgy.business.service;

import com.entelgy.business.dto.JsonentelgyResponse;

import reactor.core.publisher.Mono;

public interface EntelgyService {
	
	public Mono<JsonentelgyResponse> getJsonplaceholderList();

}
