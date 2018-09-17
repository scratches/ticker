package com.example.demo;

import java.time.Duration;
import java.util.Date;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public Supplier<Flux<String>> tock() {
		return () -> Flux.interval(Duration.ofSeconds(5))
				.map(value -> "Hello - " + value + ": " + new Date());
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
