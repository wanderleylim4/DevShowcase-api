package br.com.sawa.devshowcase_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.sawa.devshowcase_api")
public class DevShowcaseApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevShowcaseApiApplication.class, args);
    }
}
