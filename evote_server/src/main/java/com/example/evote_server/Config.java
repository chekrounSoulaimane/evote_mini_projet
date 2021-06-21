/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.evote_server;

import com.example.evote_server.contract.RMIClientContract;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 *
 * @author Lenovo
 */
@SuppressWarnings("deprecation")
@Configuration
public class Config {
    
    @Bean
    public RmiServiceExporter getRMIService(ApplicationContext context) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName("client_services");
        rmiServiceExporter.setService(context.getBean("RMIClientService"));
        rmiServiceExporter.setRegistryPort(1099);
        rmiServiceExporter.setServiceInterface(RMIClientContract.class);
        return rmiServiceExporter;
    }
}
