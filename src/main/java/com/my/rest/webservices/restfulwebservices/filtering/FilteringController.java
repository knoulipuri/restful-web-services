package com.my.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retieveSomeBean() {
		return new SomeBean("value1","value2","value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retieveSomeBeansLst() {
		return Arrays.asList(new SomeBean("value1","value2","value3"),
				new SomeBean("value12","value22","value33"));
	}
	
	//field1, field2
	@GetMapping("/filtering-dynamic")
	public MappingJacksonValue retieveSomeBeanDynamic() {
		SomeBeanDynamic someBeanDynamic=new SomeBeanDynamic("value1","value2","value3");
		MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBeanDynamic);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters=new SimpleFilterProvider().addFilter("someBeanDynamic", filter);
		
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}
	//field2, field3
	@GetMapping("/filtering-list-dynamic")
	public MappingJacksonValue retieveSomeBeansLstDynamic() {
		List<SomeBeanDynamic> someBeanDynamics=Arrays.asList(new SomeBeanDynamic("value1","value2","value3"),
				new SomeBeanDynamic("value12","value22","value33"));
		
		
		MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBeanDynamics);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filters=new SimpleFilterProvider().addFilter("someBeanDynamic", filter);
		
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue;
	}

}
