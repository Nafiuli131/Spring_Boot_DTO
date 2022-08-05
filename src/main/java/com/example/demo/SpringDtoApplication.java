package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDtoApplication implements CommandLineRunner {
	@Autowired
	com.example.demo.repository.userRepository userRepository ;
	public static void main(String[] args) {
		SpringApplication.run(SpringDtoApplication.class, args);
		System.out.println("main run method");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("commandlinerunner");
		User user = new User();

		user.setFirstName("Nafiul");
		user.setLastName("Islam");
		user.setEmail("nafiuli131@gmail.com");
		user.setPassword("secret");
		User user2 = new User();

		user2.setFirstName("Nayeem");
		user2.setLastName("Islam");
		user2.setEmail("nayeem@gmail.com");
		user2.setPassword("topsecret");
		userRepository.save(user);
		userRepository.save(user2);
	}
}
