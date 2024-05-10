package com.example.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.apache.camel.builder.RouteBuilder;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);

		CamelContext context = new DefaultCamelContext();

		// Adding routes to CamelContext
		context.addRoutes(new MyRouteBuilder());

		context.start();
		Thread.sleep(5000);
		context.stop();
	}

	// Define your routes in a separate class extending RouteBuilder
	static class MyRouteBuilder extends RouteBuilder {
		@Override
		public void configure() throws Exception {
			System.out.println("Starting routes..");

			from("file:C:/DEV/playground/apache-camel/tum_dosyalar/a?noop=true")
					.to("file:C:/DEV/playground/apache-camel/tum_dosyalar/b");

			System.out.println("Routes configured..");
		}
	}
}

