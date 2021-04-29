package com.sapient.graphql.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ReviewDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public ReviewDto() {
		super();
	}

	private Long reviewId;

	private String reviewName;
	private String dueForReview;
	private String frequency;
	private String reviewType;
	private String lastUpdated;

}
