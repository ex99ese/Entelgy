package com.entelgy.business.proxy;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.entelgy.business.model.JsonplaceholderResponse;
import com.entelgy.business.utils.Properties;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ClientProxy {
	
	@Autowired
	private Properties propertie;

	//METODO CON RESTTEMPLATE (EN USO)
	public List<JsonplaceholderResponse> getList(){
		log.info("URI:{}",propertie.getUrl());
	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<JsonplaceholderResponse[]> response = restTemplate.getForEntity(propertie.getUrl(), JsonplaceholderResponse[].class);
	    return Arrays.asList(response.getBody());
		
	}
	
	//METODO REACTIVO (OPCIONAL)
	/*public Flux<JsonplaceholderResponse> getListReactive(){		
		Flux<JsonplaceholderResponse> jsonplaceholderFlux = WebClient.create()
				.get()
				.uri(propertie.getUrl())
				.retrieve()
				.bodyToFlux(JsonplaceholderResponse.class);
		jsonplaceholderFlux.subscribe(jsonplaceholder -> log.info(jsonplaceholder.toString()));
		return jsonplaceholderFlux;
		
	}*/
	

}
