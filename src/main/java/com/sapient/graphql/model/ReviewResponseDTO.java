package com.sapient.graphql.model;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDTO {


	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-uuuu HH:mm:ss:SSS")
				.withLocale(Locale.getDefault()).withZone(ZoneId.systemDefault());
	
	private String status;
	@JsonInclude(Include.NON_NULL)
	private List<ErrorDetail> errorDetails;
	private List<ReviewDto> reviews;
	private final String timestamp = formatter.format(Instant.now());
}
