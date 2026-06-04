package com.pratik.tutorial;

import com.pratik.tutorial.LooseCoupling.EmailService;
import com.pratik.tutorial.LooseCoupling.NotificationService;
import com.pratik.tutorial.LooseCoupling.SmsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);
	}{
		NotificationService eservice=new EmailService();
		eservice.send();
		NotificationService smsService=new SmsService();
		smsService.send();
	}

}
