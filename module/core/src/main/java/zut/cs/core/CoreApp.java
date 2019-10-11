package zut.cs.core;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;

@SpringBootApplication(scanBasePackages = {"zut.cs.*"})
@EnableSwagger2Doc
@EnableEurekaClient
public class CoreApp {
//    @Bean
//    @LoadBalanced
//    public RestTemplate getBean() {
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(CoreApp.class, args);
    }
}