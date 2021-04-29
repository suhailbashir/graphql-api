package com.sapient.graphql.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.sapient.graphql.model.Criteria;
import com.sapient.graphql.model.ReviewDto;

import reactor.core.publisher.Flux;
@Component
public class DomainLayerIntegrator {


	@Value("${baseUrl}")
	private String url;

	
	WebClient webClient;

	@PostConstruct
	public void init() {
		webClient = WebClient.builder().baseUrl(url)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

	public Flux<ReviewDto> getReviews(Criteria criteria) {
		return webClient.post().uri("/reviews").bodyValue(criteria).retrieve().bodyToFlux(ReviewDto.class);
	}
	
	
	
}
