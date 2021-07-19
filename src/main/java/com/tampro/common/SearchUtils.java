package com.tampro.common;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchUtils {
	
	private RestHighLevelClient restHighLevelClient;
	
	private static final Logger LOG = LoggerFactory.getLogger(SearchUtils.class);

	@Autowired
	public SearchUtils(RestHighLevelClient restHighLevelClient) {
		this.restHighLevelClient = restHighLevelClient;
	}

	public static SearchRequest buildSearchRequest(final String indexName, String field, String value) {
		
		try {
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
					.postFilter(getQueryBuilder(field, value));
			SearchRequest searchRequest = new SearchRequest(indexName);
			searchRequest.source(searchSourceBuilder);
			return searchRequest;
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error(" build search request failed {} ", e);
			return null;
		}
	}
	
	public static QueryBuilder getQueryBuilder(String field, String value){
		if(field == null || value == null) {
			return null;
		}
		return QueryBuilders.matchQuery(field, value).operator(Operator.AND);
	}

}
