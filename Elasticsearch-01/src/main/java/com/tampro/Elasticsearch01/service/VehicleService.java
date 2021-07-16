package com.tampro.Elasticsearch01.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tampro.Elasticsearch01.domain.Vehicle;
import com.tampro.Elasticsearch01.helper.Indices;
import com.tampro.Elasticsearch01.search.SearchRequestDTO;
import com.tampro.Elasticsearch01.search.util.SearchUtil;

@Service
public class VehicleService {
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(VehicleService.class);

	private final RestHighLevelClient client;
	
	@Autowired
	public VehicleService(RestHighLevelClient client) {
		this.client = client;
	}
	
    public List<Vehicle> search(final SearchRequestDTO dto) {
        final SearchRequest request = SearchUtil.buildSearchRequest(
                Indices.VEHICLE_INDEX,
                dto
        );

        return searchInternal(request);
    }

    public List<Vehicle> getAllVehiclesCreatedSince(final Date date) {
        final SearchRequest request = SearchUtil.buildSearchRequest(
                Indices.VEHICLE_INDEX,
                "created",
                date
        );

        return searchInternal(request);
    }

    private List<Vehicle> searchInternal(final SearchRequest request) {
        if (request == null) {
            LOG.error("Failed to build search request");
            return Collections.emptyList();
        }

        try {
            final SearchResponse response = client.search(request, RequestOptions.DEFAULT);

            final SearchHit[] searchHits = response.getHits().getHits();
            final List<Vehicle> vehicles = new ArrayList<>(searchHits.length);
            for (SearchHit hit : searchHits) {
                vehicles.add(
                        MAPPER.readValue(hit.getSourceAsString(), Vehicle.class)
                );
            }

            return vehicles;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }
	
	public Boolean index(final Vehicle vehicle) {
		try {
			final String vehicleAsString = MAPPER.writeValueAsString(vehicle);
			
			final IndexRequest request = new IndexRequest(Indices.VEHICLE_INDEX);
			request.id(vehicle.getId());
			request.source(vehicleAsString, XContentType.JSON);
			
			final IndexResponse response = client.index(request, RequestOptions.DEFAULT);
			 
			return response != null && response.status().equals(RestStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			LOG.error(e.getMessage(), e);
			return false;
		}
	}
	
	public Vehicle getById(final String vehicleId) {
		try {
			final GetResponse documentFields = client.get
						(new GetRequest(Indices.VEHICLE_INDEX, vehicleId), 
								RequestOptions.DEFAULT);
			if(documentFields == null || documentFields.isSourceEmpty()) {
				return null;
			}
			return MAPPER.readValue(documentFields.getSourceAsString(), Vehicle.class);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return null;
		}
		 
	}
	
}
