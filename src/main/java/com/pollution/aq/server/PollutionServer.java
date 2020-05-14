package com.pollution.aq.server;

import com.pollution.aq.server.properties.AQProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AQProperties.class)
public class PollutionServer
{
    public static void main( String[] args )
    {
        SpringApplication.run(PollutionServer.class, args);
    }
}
