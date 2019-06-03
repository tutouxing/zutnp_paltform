package zut.cs.core;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"zut.cs.*"})
@EnableSwagger2Doc
@EnableEurekaClient
@EnableFeignClients
@EnableHystrixDashboard
@EnableHystrix
@EnableTurbine
@EnableCircuitBreaker
//@EnableCaching
public class CoreApp {
    @Bean
    @LoadBalanced
    public RestTemplate getBean(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(CoreApp.class, args);
    }
}