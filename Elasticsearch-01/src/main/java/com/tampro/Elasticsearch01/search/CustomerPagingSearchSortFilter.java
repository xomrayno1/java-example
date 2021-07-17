package com.tampro.Elasticsearch01.search;

import com.tampro.Elasticsearch01.domain.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerPagingSearchSortFilter {
	private Customer customer;
	private String[] fields;
    private int pageNumber;
    private int pageSize; 

}
