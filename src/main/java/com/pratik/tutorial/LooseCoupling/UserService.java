package com.pratik.tutorial.LooseCoupling;

/* we are doing constructor dependency injection*/
public class UserService {
    NotificationService service;

    public UserService(NotificationService service){
        this.service=service;
    }
    public void notifyUser(){
        service.send();
    }
}
