package com.sapient.graphql.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Criteria implements Serializable {

	private static final long serialVersionUID = 1L;
	String pageNumber;
	String pageSize;
	Sort sort;

}
