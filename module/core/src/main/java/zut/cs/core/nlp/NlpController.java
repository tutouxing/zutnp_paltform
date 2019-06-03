package zut.cs.core.nlp;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("nlp")
@Api(tags = "自然语言处理接口")
public class NlpController {
    @Autowired
    NlpFeignClient nlpFeignClient;

    @HystrixCommand
    @PostMapping("en/dependency")
    public String getEnDep(@RequestParam String text){
        return nlpFeignClient.getEnglishDependency(text);
    }

    @HystrixCommand
    @PostMapping("ch/dependency")
    public String getChDep(@RequestParam String text){
        return nlpFeignClient.getChineseDependency(text);
    }

    @HystrixCommand
    @PostMapping("en/tree")
    public String getEnTree(@RequestParam String text){
        return nlpFeignClient.getEnglishTree(text);
    }

    @HystrixCommand
    @PostMapping("ch/tree")
    public String getChTree(@RequestParam String text){
        return nlpFeignClient.getChineseTree(text);
    }

    @HystrixCommand
    @PostMapping("en/wpn")
    public List<Object> getEnWpn(@RequestParam String text){
        return nlpFeignClient.getEnglishWpn(text);
    }


    @HystrixCommand
    @PostMapping("ch/wpn")
    public List<Object> getChWpn(@RequestParam String text){
        return nlpFeignClient.getChineseWpn(text);
    }

}
