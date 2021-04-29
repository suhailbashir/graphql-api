package com.sapient.graphql.exceptions;

import java.util.List;

import org.springframework.stereotype.Component;

import graphql.ErrorClassification;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class MyException extends ApiException implements GraphQLError {

	public MyException(int code, String message) {
		super(code, message);
	}

	private static final long serialVersionUID = 1L;

	

	@Override
	public List<SourceLocation> getLocations() {
		return null;
	}

	@Override
	public ErrorClassification getErrorType() {
		return ErrorType.DataFetchingException;
	}

}