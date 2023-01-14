package com.day5.day5.util;

import org.springframework.stereotype.Component;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@Component
public class AppStartupEvent implements ApplicationListener<ApplicationReadyEvent> {
    
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println(event.getApplicationContext().getEnvironment());
        System.out.println("Application started on port: " + event.getApplicationContext().getEnvironment().getProperty("server.port"));
    }
}
