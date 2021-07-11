package com.nisum.test.nisum;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class NisumApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(NisumApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//        String psw = "admin";
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodePsw = encoder.encode(psw);
//        System.out.println(encodePsw);
    }
}
