package com.sapient.graphql.service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sapient.graphql.exceptions.MyException;
import com.sapient.graphql.model.Criteria;
import com.sapient.graphql.model.ReviewDto;
import com.sapient.graphql.model.Sort;

import graphql.schema.DataFetcher;

@Service
public class ReviewService {

	@Autowired
	private DomainLayerIntegrator domainLayerIntegrator;

	public DataFetcher<List<ReviewDto>> getReviews() {
		return env -> {

			LinkedHashMap<String, Object> ssHashMap = env.getArgument("criteria");
			Criteria cbCriteria = Criteria.builder().build();

			ssHashMap.forEach((k, v) -> {
				if (k.equals("pageNumber")) {
					cbCriteria.setPageNumber(v.toString());
				} else if (k.equals("pageSize")) {
					cbCriteria.setPageSize(v.toString());
				} else if (k.equals("sort")) {
					Sort sort = Sort.builder().build();

					String so[] = v.toString().split(",");
					System.out.println(so);
					Arrays.stream(so).forEach(a -> {
						String s[] = a.split("=");
						System.out.println(s);
						if (a.contains("direction")) {
							sort.setDirection(s[1].replaceAll("[^A-Za-z0-9]", ""));
						} else if (a.contains("sortBy")) {
							sort.setSortBy(s[1].replaceAll("[^A-Za-z0-9]", ""));
						}
					});

					cbCriteria.setSort(sort);

				}
			});
			List<ReviewDto> listOfDtos = null;
			try {
				listOfDtos = domainLayerIntegrator.getReviews(cbCriteria).collectList().block();
			} catch (Exception e) {
				throw new MyException(HttpStatus.NOT_FOUND.value(), "No Data found  for  query");
			}

			return listOfDtos;
		};
	}
}
