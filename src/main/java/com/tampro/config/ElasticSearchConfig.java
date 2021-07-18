package com.tampro.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.tampro.repository")
@ComponentScan(basePackages = "com.tampro")
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration{

	@Value("${elasticsearch.url}")
	private String elasticsearchURL;

	@Override
	public RestHighLevelClient elasticsearchClient() {
		// TODO Auto-generated method stub
		final ClientConfiguration configuration =  ClientConfiguration.builder()
										.connectedTo(elasticsearchURL).build();
		return RestClients.create(configuration).rest();
	}
	
}
