package org.sid.costumerservice;

import org.sid.costumerservice.entities.Customer;
import org.sid.costumerservice.repositories.CustomerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@RefreshScope
public class CostumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CostumerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepo customerRepo){
		return args -> {
				customerRepo.saveAll(List.of(
						Customer.builder().name("Mohamed").email("mh@gmail.com").build(),
						Customer.builder().name("hassan").email("hassan@gmail.com").build(),
						Customer.builder().name("tarik").email("tarik@gmail.com").build()
				));
				customerRepo.findAll().forEach(customer -> {
					System.out.println(String.format(customer.getEmail(),customer.getName()));
				});
		};
	}
}
