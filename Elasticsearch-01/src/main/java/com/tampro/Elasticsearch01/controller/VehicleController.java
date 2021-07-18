package com.tampro.Elasticsearch01.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.Elasticsearch01.domain.Vehicle;
import com.tampro.Elasticsearch01.helper.VehicleDummyDataService;
import com.tampro.Elasticsearch01.search.SearchRequestDTO;
import com.tampro.Elasticsearch01.service.VehicleService;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {
	private final VehicleService service;
	private final VehicleDummyDataService dummyDataService;

	@Autowired
	public VehicleController(VehicleService vehicleService, VehicleDummyDataService dummyDataService) {
		this.service = vehicleService;
		this.dummyDataService = dummyDataService;
	}

	@PostMapping
	public void index(@RequestBody final Vehicle vehicle) {
		service.index(vehicle);
	}

	@PostMapping("/insertdummydata")
	public void insertDummyData() {
		dummyDataService.insertDummyData();
	}

	@GetMapping("/{id}")
	public Vehicle getById(@PathVariable final String id) {
		return service.getById(id);
	}

	@PostMapping("/search")
	public List<Vehicle> search(@RequestBody final SearchRequestDTO dto) {
		return service.search(dto);
	}

	@GetMapping("/search/{date}")
	public List<Vehicle> getAllVehiclesCreatedSince(
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") final Date date) {
		return service.getAllVehiclesCreatedSince(date);
	}

	@PostMapping("/searchcreatedsince/{date}")
	public List<Vehicle> searchCreatedSince(@RequestBody final SearchRequestDTO dto,
			@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") final Date date) {
		return service.searchCreatedSince(dto, date);
	}
}
