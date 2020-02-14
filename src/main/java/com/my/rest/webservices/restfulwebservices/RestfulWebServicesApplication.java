package com.my.rest.webservices.restfulwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	@Bean
	public LocaleResolver localeResolver() {
		//First-way
		/*SessionLocaleResolver localeResolver=new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;*/
		//second-way
		AcceptHeaderLocaleResolver localeResolver=new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	//First-way programatic bean
	/*@Bean //method name should be messageSource()
	public ResourceBundleMessageSource resourceBundleMessageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource=new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("messages"); 
		return resourceBundleMessageSource;
	}*/
	
	//Second-way
	//Directly from properties file

}
