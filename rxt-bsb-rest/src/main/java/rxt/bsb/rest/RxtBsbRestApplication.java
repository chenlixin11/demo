package rxt.bsb.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackages= {"rxt.bsb.api"})
@EnableDiscoveryClient
@EnableEurekaClient
public class RxtBsbRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RxtBsbRestApplication.class, args);
	}

}
