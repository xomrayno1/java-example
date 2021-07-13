package com.tampro.api.common;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.tampro.api.domain.Car;
import com.tampro.api.repository.CarRepository;
import com.tampro.api.service.CarService;

@Component
public class CarElasticDatasource {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(CarElasticDatasource.class);
	
	@EventListener(classes = ApplicationReadyEvent.class)
	public void populateData() {
		log.info("Start delete ");
		var response = restTemplate.exchange("http://localhost:9200/Elasticsearch-01", HttpMethod.DELETE, null, String.class);
		log.info("Delete result : " + response.getBody());
		var cars = new ArrayList<Car>();
		for(int i = 0 ; i < 10000 ; i++) {
			cars.add(carService.generateCar());
		}
		carRepository.saveAll(cars);
		
		log.info("Car in Elasticsearch : "+ carRepository.count());
	}

}
