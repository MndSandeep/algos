package com.turvo.assesment.shipmenttracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;

/**
 * Main application class which initializes all the required
 * configuration & boot the application
 * @author Sandeep Allamsetti
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableJms
@EnableJpaRepositories
public class App 
{
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
