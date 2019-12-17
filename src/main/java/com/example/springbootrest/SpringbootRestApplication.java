package com.example.springbootrest;

import com.example.springbootrest.enitities.Order;
import com.example.springbootrest.enitities.User;
import com.example.springbootrest.repositories.UserReporisotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class SpringbootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestApplication.class, args);
	}



	@Bean
	public LocaleResolver localeResolver(){
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return  localeResolver;
	}
	@Bean
	public ResourceBundleMessageSource messsageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");

		return messageSource;
	}
//	@Bean
//	CommandLineRunner initDatabase(UserReporisotry userReporisotry){
//		return args -> createData(userReporisotry);
//	}
//	@Autowired
//	private PasswordEncoder encoder;
//
//	private void createData(UserReporisotry r){
//
//		for (int i = 1; i <= 10; i++) {
//
//			String plainPass = "abc";
//			String password = encoder.encode(plainPass.subSequence(0, plainPass.length()));
//
//			User user = new User("springboot"+i, "sb firts name"+i, "sb latname"+i,
//					i+"something@gmail.com","USER", "001"+i,new ArrayList<>(), "Jkt"+1,password);
////			User user = new User();
////			user.setUsername("abc");
//
//			List<Order> orders = new ArrayList<>();
//			orders.add(new Order("order desc 01 "+i, user));
//			orders.add(new Order("order desc 02 "+i, user));
//			orders.add(new Order("order desc 03 "+i, user));
//
//			user.setOrders(orders);
//
//			if(i==1){
//				user.setRole("ADMIN");
//			}
//
//			r.save(user);
//		}
//	}
}
