package com.entelgy.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entelgy.business.dto.JsonentelgyResponse;
import com.entelgy.business.service.EntelgyService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/entelgy")
public class EntelgyController {
	
	@Autowired
	private EntelgyService service;
	
	@PostMapping("/list")
	public ResponseEntity<Mono<JsonentelgyResponse>> getInfo() {
		return new ResponseEntity<>(service.getJsonplaceholderList(), HttpStatus.OK);
		
	}

}
