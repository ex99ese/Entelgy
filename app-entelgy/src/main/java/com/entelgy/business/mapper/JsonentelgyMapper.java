package com.entelgy.business.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.entelgy.business.dto.JsonentelgyResponse;
import com.entelgy.business.model.JsonplaceholderResponse;

@Component
public class JsonentelgyMapper {

	public JsonentelgyResponse buildJsonentelgyResponse(List<JsonplaceholderResponse> jsonplaceholder) {

		return JsonentelgyResponse.builder()
				.data(jsonplaceholder.stream()
						.map(json -> json.getPostId() + "|" + json.getId() + "|" + json.getEmail())
						.collect(Collectors.toList()))
				.build();
	}
}
