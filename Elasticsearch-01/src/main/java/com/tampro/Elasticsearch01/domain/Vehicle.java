package com.tampro.Elasticsearch01.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vehicle {
	@Id
	private String id;
	private String number;
	private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date created;

}
