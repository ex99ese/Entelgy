package com.entelgy.business.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.entelgy.business.dto.JsonentelgyResponse;
import com.entelgy.business.service.EntelgyService;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class EntelgyControllerTest {

	@Mock
	private EntelgyService service;
	
	@InjectMocks
	private EntelgyController controller;
	
	@Test
	void getInfoTest() {		
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		when(service.getJsonplaceholderList()).thenReturn(Mono.just(new  
				JsonentelgyResponse()
				));
		ResponseEntity<Mono<JsonentelgyResponse>> responseEntity =  controller.getInfo();
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}

}
