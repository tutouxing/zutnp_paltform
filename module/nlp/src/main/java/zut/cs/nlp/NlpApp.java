package zut.cs.nlp;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableSwagger2Doc
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EnableEurekaClient
public class NlpApp {
    public static void main(String[] args) {
        SpringApplication.run(NlpApp.class);
    }
}
