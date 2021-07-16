package com.tampro.Elasticsearch01.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.tampro.Elasticsearch01.repository")
@ComponentScan(basePackages = "com.tampro.Elasticsearch01")
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration{
	
	 
	@Value("${elasticsearch.url}")
	private String elasticsearchUrl;

	@Bean
	@Override
	public RestHighLevelClient elasticsearchClient() {
		// TODO Auto-generated method stub
		final ClientConfiguration configuration = ClientConfiguration
						.builder().connectedTo(elasticsearchUrl).build();
		return RestClients.create(configuration).rest();
	}
	
	
 
}
