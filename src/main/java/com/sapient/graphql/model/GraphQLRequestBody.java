/**
 * 
 */
package com.sapient.graphql.model;

import java.util.Map;

import lombok.Data;

@Data
public class GraphQLRequestBody {
	
	private String query;
	private String operationName;
	private Map<String, Object> variables;
	
}
