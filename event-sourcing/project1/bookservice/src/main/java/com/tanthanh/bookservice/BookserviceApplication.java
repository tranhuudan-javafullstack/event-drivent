package com.tanthanh.bookservice;

import com.tanthanh.bookservice.config.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@EnableDiscoveryClient
@SpringBootApplication
@Import({AxonConfig.class})
public class BookserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookserviceApplication.class, args);
    }

}
