package com.nec.mail.sender.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.nec.mail.sender.*")
@SpringBootApplication
public class ApplicationMain {

	public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
	
}
