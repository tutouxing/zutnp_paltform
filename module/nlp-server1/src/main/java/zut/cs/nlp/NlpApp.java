package zut.cs.nlp;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableSwagger2Doc
@SpringBootApplication
//@EnableEurekaClient
//@EnableHystrix
//@EnableHystrixDashboard
//@EnableCircuitBreaker
//@EnableTurbine
public class NlpApp {
    public static void main(String[] args) {
        SpringApplication.run(NlpApp.class);
    }
}
