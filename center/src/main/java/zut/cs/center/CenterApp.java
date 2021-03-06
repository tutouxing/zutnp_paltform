package zut.cs.center;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableSwagger2Doc
public class CenterApp {
    public static void main(String[] args) {
        SpringApplication.run(CenterApp.class, args);
    }
}
