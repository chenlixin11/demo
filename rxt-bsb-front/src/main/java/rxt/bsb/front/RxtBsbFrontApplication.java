package rxt.bsb.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackages= {"rxt.bsb.api"})
@EnableDiscoveryClient
@EnableEurekaClient
public class RxtBsbFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(RxtBsbFrontApplication.class, args);
	}

}
