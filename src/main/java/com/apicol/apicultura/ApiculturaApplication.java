package com.apicol.apicultura;

import com.apicol.apicultura.model.Product;
import com.apicol.apicultura.service.ProductService;
import com.apicol.apicultura.service.implementation.BossImplementation;
import com.apicol.apicultura.model.Boss;
import com.apicol.apicultura.model.User;
import com.apicol.apicultura.repository.BossRepository;
import com.apicol.apicultura.repository.ProductRepository;
import com.apicol.apicultura.repository.UserRepository;
import com.apicol.apicultura.service.implementation.ProductImplementation;
import com.apicol.apicultura.service.implementation.UserImplementation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.apicol.apicultura.repository"})
@EnableJpaRepositories

public class ApiculturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiculturaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ProductRepository productRepository, UserRepository userRepository, BossRepository bossRepository) {
		return args -> {
			BossImplementation bossImplementation=new BossImplementation(bossRepository, userRepository, productRepository);
			UserImplementation userImplementation=new UserImplementation(userRepository,productRepository);
			ProductImplementation productImplementation=new ProductImplementation(productRepository);
			User user1=new User();
			user1.setFname("Catalina");
			user1.setLname("Bulina");
			user1.setAdress("Str. Principala");
			user1.setPassword("123");
			user1.setEmail("calina@yahoo.com");
			user1.setPhoneNumber("0742554003");
			userRepository.save(user1);

			Product product = new Product();
			product.setPrice(100);
			product.setNameProduct("Afumatoare");
			product.setQuantites(34);
			product.setBrand("Apicola");
			productRepository.save(product);

			Boss boss1=new Boss();
			boss1.setId(1L);
			boss1.setFname("Calina");
			boss1.setLname("Popotoiu");
			boss1.setEmail("aaa@yahoo.com");
			boss1.setPassword("aaab");
			bossRepository.save(boss1);
			//System.out.println(boss1.getFname());
			//System.out.println(bossImplementation.findUsersByBoss());
			userImplementation.updateUserPassword(user1, "155");
			System.out.println(userImplementation.login(user1,"calina@yahoo.com","155"));
			System.out.println(bossImplementation.login(boss1,"calina@yahoo.com","155"));
			System.out.println(bossImplementation.login(boss1,"aaa@yahoo.com","aaab"));
			
		};
	}

}
