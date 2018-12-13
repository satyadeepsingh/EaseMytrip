package org.ems.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdvancedShippingDataIntegrationTrackingService {
	
	private static final Logger logger = LoggerFactory.getLogger(AdvancedShippingDataIntegrationTrackingService.class);

	public static void main(String[] args) {
		
		 SpringApplication.run(AdvancedShippingDataIntegrationTrackingService.class, args);
		 logger.info("Started AdvancedShippingDataIntegrationTrackingService successfully : ");

	}

}
