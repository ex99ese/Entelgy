package com.entelgy.business.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.entelgy.business.dto.JsonentelgyResponse;
import com.entelgy.business.mapper.JsonentelgyMapper;
import com.entelgy.business.model.JsonplaceholderResponse;
import com.entelgy.business.proxy.ClientProxy;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class EntelgyServiceImplTest {

	@InjectMocks
	private EntelgyServiceImpl service;

	@Mock
	private ClientProxy proxy;

	@Mock
	private JsonentelgyMapper mapper;
	
	private JsonentelgyResponse entelgyResponse;
	
	private List<JsonplaceholderResponse> listJsonplaceholders;
	
	@BeforeEach
	void setUp() {
		JsonplaceholderResponse response = JsonplaceholderResponse.builder()
				.body("laudantium enim quasi est quidem magnam voluptate ipsam")
				.email("Eliseo@gardner.biz")
				.id(1)
				.name("id labore ex et quam laborum")
				.postId(1)
				.build();
		listJsonplaceholders = new ArrayList<>();
		listJsonplaceholders.add(response);		
		when(proxy.getList()).thenReturn(listJsonplaceholders);
		
		String[] strArr = {"4|19|Madelynn.Gorczany@darion.biz"};
		List<String> listentelgy = Arrays.asList(strArr);
		entelgyResponse = JsonentelgyResponse.builder()
				.data(listentelgy)
				.build();
		when(mapper.buildJsonentelgyResponse(listJsonplaceholders)).thenReturn(entelgyResponse);
	}

	@Test
	void getJsonplaceholderListTest() {
		Mono<JsonentelgyResponse> mono = service.getJsonplaceholderList();
		StepVerifier.create(mono.log())
		.expectNext(entelgyResponse)
		.verifyComplete();
	}

}
