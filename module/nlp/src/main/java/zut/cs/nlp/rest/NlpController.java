package zut.cs.nlp.rest;

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

    @PostMapping("nlp_en/")
    public Object handleEn(String text) {
        Result result = englishNlp.runAllAnnotators(text);
        return result;
    }
    @PostMapping("nlp_ch/")
    public Object handleCh(String text) {
        Result result = chineseNlp.runChineseAnnotators(text);
        return result;
    }
}
