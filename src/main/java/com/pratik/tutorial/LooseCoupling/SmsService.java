package com.pratik.tutorial.LooseCoupling;

public class SmsService implements NotificationService{
    @Override
    public void send(){
        System.out.println("SMS service is being used");
    }
}
