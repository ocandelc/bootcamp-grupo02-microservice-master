package com.nttdata.bootcamp.master;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MasterApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MasterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MasterApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Init Project");
	}

}
