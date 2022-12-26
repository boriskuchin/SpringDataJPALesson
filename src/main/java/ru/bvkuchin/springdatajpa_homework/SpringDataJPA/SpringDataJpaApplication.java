package ru.bvkuchin.springdatajpa_homework.SpringDataJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.services.ProductService;
import ru.bvkuchin.springdatajpa_homework.SpringDataJPA.utils.ApplicationContextProvider;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	ApplicationContextProvider applicationContextProvider;

    public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}


	public void run(String...args) throws Exception {
//		ProductService service = applicationContextProvider.getApplicationContext().getBean(ProductService.class);
//
//		service.getAllProducts().forEach(System.out::println);
	}





}
