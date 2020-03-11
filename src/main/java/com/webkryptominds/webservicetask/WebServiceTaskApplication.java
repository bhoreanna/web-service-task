package com.webkryptominds.webservicetask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class WebServiceTaskApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceTaskApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WebServiceTaskApplication.class, args);
		LOGGER.info("WebServiceTask Application UP Successfully...!");

		System.out.println("WebServiceTask Application UP Successfully...!");
	}

}
