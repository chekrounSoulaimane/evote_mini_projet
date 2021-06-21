package com.example.evote_server;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@EnableAutoConfiguration
@EnableSpringConfigured
@ComponentScan
@SpringBootApplication
public class EvoteServerApplication {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        SpringApplication.run(EvoteServerApplication.class, args);
    }

}
