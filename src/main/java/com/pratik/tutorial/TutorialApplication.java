package com.pratik.tutorial;

import com.pratik.tutorial.LooseCoupling.EmailService;
import com.pratik.tutorial.LooseCoupling.NotificationService;
import com.pratik.tutorial.LooseCoupling.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);
	}{
		NotificationService emailservice=new EmailService();
		UserService userservice=new UserService(emailservice);
		userservice.notifyUser();


	}

}
