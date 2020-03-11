package com.webkryptominds.webservicetask.modules.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webkryptominds.webservicetask.common.util.WebServiceConstent;

@CrossOrigin(origins = WebServiceConstent.CROSS_ORIGIN_URL)
@RestController
public class ApplicationController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationController.class);
  //  private static Logger LOGGER_LOG4J = LogManager.getLogger(ApplicationController.class);

	@GetMapping("/")
	public String getApplicationInfo() {

		LOGGER.info("WebServiceTask Application UP Successfully...!");
		return "WebServiceTask Application UP Successfully...!";

	}

}
