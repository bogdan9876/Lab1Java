package ua.lviv.iot.algo.part1.lab1.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ua.lviv.iot.algo.part1.lab1.service",
		"ua.lviv.iot.algo.part1.lab1.controller",
		"ua.lviv.iot.algo.part1.lab1.model"})
public class RestApplication {

	public static void main(final String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
}
