package com.tampro.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tampro.common.CommonUtil;

@Service
public class IndexService {
	
	private static final List<String> INDICES_TO_CREATE = List.of("customer");
	
	private static final Logger LOG = LoggerFactory.getLogger(IndexService.class);

	private RestHighLevelClient restHighLevelClient;
	
	@Autowired
	public IndexService(RestHighLevelClient restHighLevelClient) {
		this.restHighLevelClient = restHighLevelClient;
	}

	@PostConstruct
	public void tryToCreateIndices() {
		LOG.info("create index");
		reCreateIndex();
	}
	
	public void reCreateIndex() {
		for(String indices : INDICES_TO_CREATE) {
			try {
				boolean exists = restHighLevelClient.indices()
									.exists(new GetIndexRequest(indices), 
											RequestOptions.DEFAULT);
				if(exists) {
					restHighLevelClient.indices().delete(new DeleteIndexRequest(indices), 
							RequestOptions.DEFAULT);
				}
				
				String settings = CommonUtil.loadAsString("static/es-settings.json");
				String mapping = CommonUtil.loadAsString("static/mappings/"+ indices +".json");
				
				CreateIndexRequest createIndexRequest = new CreateIndexRequest(indices);
				if(settings != null) {
					createIndexRequest.settings(settings, XContentType.JSON);	
				}
				
				if(mapping != null) {
					createIndexRequest.mapping(mapping, XContentType.JSON);	
				}
				
				restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
				
			} catch (Exception e) {
				// TODO: handle exception
				LOG.error("re create index failed {} ", e);
			}
		}
		
	}
	
}
