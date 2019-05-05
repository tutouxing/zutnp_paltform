package zut.cs.nlp.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import zut.cs.nlp.bean.Result;
import zut.cs.nlp.example.StanfordChineseNlpExample;
import zut.cs.nlp.example.StanfordEnglishNlp;

@RestController
public class NlpController {
    StanfordChineseNlpExample chineseNlp = new StanfordChineseNlpExample();
    //    StanfordEnglishNlpExample englishNlp = new StanfordEnglishNlpExample();
    StanfordEnglishNlp englishNlp = new StanfordEnglishNlp();

    @HystrixCommand
    @PostMapping("/nlp_en")
    public Object handleEn(String text) {
        Result result = englishNlp.runAllAnnotators(text);
        return result;
    }

    @HystrixCommand
    @PostMapping("/nlp_ch")
    public Object handleCh(String text) {
        Result result = chineseNlp.runChineseAnnotators(text);
        return result;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello2222";
    }
}
