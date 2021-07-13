package com.tampro.api.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.tampro.api.domain.Car;

@Repository
public interface CarRepository extends ElasticsearchRepository<Car, String>{

}
