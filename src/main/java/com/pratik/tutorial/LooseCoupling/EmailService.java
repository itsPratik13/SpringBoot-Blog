package com.pratik.tutorial.LooseCoupling;

public class EmailService implements NotificationService{
    @Override
    public void send(){
        System.out.println("Email service is being used");
    }
}
