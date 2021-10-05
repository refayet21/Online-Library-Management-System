package com.libraryapp;

import java.time.LocalDate; 
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.libraryapp.entities.Book;
import com.libraryapp.entities.User;
import com.libraryapp.services.BookService;
import com.libraryapp.services.NotificationService;
import com.libraryapp.services.UserService;
import com.libraryapp.utils.MidnightApplicationRefresh;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	BookService bookService;
	
	@Autowired
	UserService usService;
	
	@Autowired
	NotificationService notifService;
	
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@Autowired
	MidnightApplicationRefresh midAppRef;
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
		
			User user1 = new User("admin", pwEncoder.encode("test"), "refayet21@gmail.com", "Refayet Ullah", "Toiyob", "Ramgati", "01688797585", "Lakshmipur");
			user1.setRole("ROLE_ADMIN");
			
			User user2 = new User("employee", pwEncoder.encode("test"), "anamul@gamail.com", "Anamul", "Haque", "Companiganje", "01855778844", "Noakhali");
			user2.setRole("ROLE_EMPLOYEE");
			
			User user3 = new User("user", pwEncoder.encode("test"), "polash@gmail.com", "Alauddin", "Polash", "Hajiganje", "0198855774", "Chandpur");
			user3.setRole("ROLE_USER");	
			User user4 = new User("solim", pwEncoder.encode("test"), "solim@gmail.com", "Solim", "Ullah", "Sadar", "0198855774", "Feni");
			User user5 = new User("asma", pwEncoder.encode("test"), "asma@gmail.com", "Asma", "Sultana", "Jhigatola", "0175588996", "Dhaka");
			User user6 = new User("taifa", pwEncoder.encode("test"), "taifa@gmail.com", "Taifa", "Jahan", " Ghatail", "0158877445", "Tangail");
			
			
			usService.save(user1);
			usService.save(user2);
			usService.save(user3);
			usService.save(user4);
			usService.save(user5);
			usService.save(user6);
			
			
			Book book1 = new Book("Shesher Kobita", "Rabindranath  Tagore  ", 1928, 1);
			Book book2 = new Book("Rupasi Bangla", "Jibanananda Das", 1957, 1);
			Book book3 = new Book("Dhumketu", "Kazi Nazrul Islam", 1922 , 1);
			Book book4 = new Book("Putul Nacher Itikotha", "Manik Bandopadhyay ", 1956, 1);
			Book book5 = new Book("Sanjher Maya", "Begum Sufia Kamal", 1938, 3);
			Book book6 = new Book("Nakshi Kanthar Math", "Jasimuddin", 1928, 1);
			Book book7 = new Book("Musafir ", "Syed Mujtaba Ali", 1971, 3);
			Book book8 = new Book("Durgeshnandini ", "Bankimchandra Chattopadhyay", 1865, 1);
			Book book9 = new Book("Amar Bondhu Rashed", "Muhammed Zafar Iqbal", 2011, 2);
			Book book10 = new Book("Padma Nadir Majhi", "Manik Bandopadhyay ", 1956, 3);
			Book book11 = new Book("Bidrohi ", "Kazi Nazrul Islam", 1921, 4);
			Book book12 = new Book("Banalata Sen", "Jibanananda Das", 1942, 1);
			Book book13 = new Book("Sonar Tori", "Rabindranath Tagore", 1894, 2);
			Book book14 = new Book("Aguner Poroshmoni", "Humayun Ahmed", 1994 , 3);
			Book book15 = new Book("Kapalkundala ", "Bankimchandra Chattopadhyay", 1866, 2);
			
			
			bookService.save(book1);
			bookService.save(book2);
			bookService.save(book3);
			bookService.save(book4);
			bookService.save(book5);
			bookService.save(book6);
			bookService.save(book7);
			bookService.save(book8);
			bookService.save(book9);
			bookService.save(book10);
			bookService.save(book11);
			bookService.save(book12);
			bookService.save(book13);
			bookService.save(book14);
			bookService.save(book15);
			
			
			book10.setTheUser(user3);
			book10.setReturnDate(LocalDate.of(2021, 7, 23));
			
			book1.setTheUser(user3);
			book1.setReturnDate(LocalDate.of(2021, 8, 05));
			
			user3.setBooks(Arrays.asList(book10, book1));
			
			bookService.save(book1);
			bookService.save(book10);
			usService.save(user3);
						
			midAppRef.midnightApplicationRefresher();	
		};
	}

}
