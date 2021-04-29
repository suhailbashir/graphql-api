package com.sapient.graphql.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
@Component
public class CustomGraphQLErrorHandler implements GraphQLErrorHandler{

	@Override
	public List<GraphQLError> processErrors(List<GraphQLError> errors) {
		return errors.stream()
				.map(this::getNested)
				.collect(Collectors.toList());
	}

	private GraphQLError getNested(GraphQLError e) {
		if(e instanceof ExceptionWhileDataFetching) {
			ExceptionWhileDataFetching dataFetching=(ExceptionWhileDataFetching) e;
			if(dataFetching.getException() instanceof GraphQLError) {
				return (GraphQLError) dataFetching.getException();
			}
		}
		return e;
	}

}
