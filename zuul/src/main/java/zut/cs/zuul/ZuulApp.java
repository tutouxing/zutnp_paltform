package zut.cs.zuul;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(exclude =DataSourceAutoConfiguration.class)
@EnableZuulProxy
@EnableSwagger2Doc
public class ZuulApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class);
    }
}
