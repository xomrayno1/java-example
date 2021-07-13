package com.tampro.api.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.tampro.api.domain.Car;

@Service
public class RandomCarService implements CarService{

	private Random random = new Random();
	
	@Override
	public Car generateCar() {
		// TODO Auto-generated method stub
		var randomBrand = BRANDS.get(random.nextInt(BRANDS.size()));
		var randomColor = COLORS.get(random.nextInt(COLORS.size()));
		var randomType = TYPES.get(random.nextInt(TYPES.size()));
		
		var car = new Car(randomBrand, randomColor, randomType, 5000 + random.nextInt(7001)
					, random.nextBoolean(), new Date());

		var randomCount = random.nextInt(ADDITIONAL_FEATURES.size());
		var additionalFeatures = new ArrayList<String>();
		for( int i = 1; i <= randomCount; i++) {
			additionalFeatures.add(ADDITIONAL_FEATURES.get(i - 1));
		}
		car.setAdditionalFeatures(additionalFeatures);
		
		return car;
	}

}
