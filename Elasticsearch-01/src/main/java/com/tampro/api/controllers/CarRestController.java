package com.tampro.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.api.domain.Car;
import com.tampro.api.service.CarService;

@RestController
@RequestMapping("/api/v1/cars")
public class CarRestController {

	@Autowired
	private CarService carService;
	
	private Random random = new Random();
	
	private static final Logger log = LoggerFactory.getLogger(CarRestController.class);

	@GetMapping(path = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
	public Car random() {
		log.info("generate car successfully ");
		return carService.generateCar();
	}
	
	@PostMapping(path = "/echo", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String echo(@RequestBody Car car) {
		log.info("The car is : " + car);
		
		return car.toString();
	}
	
	@GetMapping(path = "/random-cars", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Car> randomCars() {
		var result = new ArrayList<Car>();
		
		for(int i =0 ; i < random.nextInt(6); i++) {
			result.add(carService.generateCar());
		}
		
		log.info("random cars successfully ");
		return result;
	}
	
}
