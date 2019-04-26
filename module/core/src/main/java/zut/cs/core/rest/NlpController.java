package zut.cs.core.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zut.cs.core.bean.Result;

@RestController
public class NlpController {
    @Autowired
    RestTemplate restTemplate;
    @PostMapping("nlp/")
    public Result getResult(@RequestParam String text,@RequestParam String lang){
        return restTemplate.postForObject("http://localhost:19999/nlp/?text="+text+"lang="+lang,null,Result.class);
    }
}
