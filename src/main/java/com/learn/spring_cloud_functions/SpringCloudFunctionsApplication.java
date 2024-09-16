package com.learn.spring_cloud_functions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringCloudFunctionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunctionsApplication.class, args);
	}

//	Method 1 of implementing serverless functions

	/**
	 *
	 * "Function" This is a functional interface defined in java 8. This takes one input and return one output
	 * This can be called using below curl
	 * curl -H "Content-Type:text/plain" localhost:8083/toUpperCase -d "helloW"
	 * @return
	 */
	@Bean
	public Function<String, String> toUpperCase(){
		return (value) -> value.toUpperCase();
	}

	/**
	 * "Supplier" This is a functional interface defined in java 8. This does not take any input. But return one output.
	 * This can be called using below curl
	 * curl -H "Content-Type:text/plain" localhost:8083/getMessage
	 */
	@Bean
	public Supplier<String> getMessage(){
		return () -> "Welcome to Malaysia!!";
	}

	/**
	 * "Consumer" This is a functional interface defined in java 8. This takes one input. but does not return anything
	 * This can be called using below curl
	 * curl -H "Content-Type:text/plain" localhost:8083/writeMessage -d "Coding is Fun".
	 * Here "Coding is Fun" will be printed on the console.
	 */
	@Bean
	public Consumer<String> writeMessage(){
		return (value) -> System.out.println(value);
	}

}
