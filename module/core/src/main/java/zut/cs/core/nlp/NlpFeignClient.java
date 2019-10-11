package zut.cs.core.nlp;

//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@FeignClient(name = "nlp", fallback = NlpFallback.class)
public interface NlpFeignClient {

    @RequestMapping(value = "/nlp_en/dependency", method = RequestMethod.POST)
    String getEnglishDependency(@RequestBody String text);

    @RequestMapping(value = "/nlp_ch/dependency", method = RequestMethod.POST)
    String getChineseDependency(@RequestBody String text);

    @RequestMapping(value = "/nlp_en/tree", method = RequestMethod.POST)
    String getEnglishTree(@RequestBody String text);

    @RequestMapping(value = "/nlp_ch/tree", method = RequestMethod.POST)
    String getChineseTree(@RequestBody String text);

    @RequestMapping(value = "/nlp_en/wpn", method = RequestMethod.POST)
    List<Object> getEnglishWpn(@RequestBody String text);

    @RequestMapping(value = "/nlp_ch/wpn", method = RequestMethod.POST)
    List<Object> getChineseWpn(@RequestBody String text);
}

@Component
class NlpFallback implements NlpFeignClient {

    @Override
    public String getEnglishDependency(String text) {
        return "请求失败...";
    }

    @Override
    public String getChineseDependency(String text) {
        return "请求失败...";
    }

    @Override
    public String getEnglishTree(String text) {
        return "请求失败...";
    }

    @Override
    public String getChineseTree(String text) {
        return "请求失败...";
    }

    @Override
    public List<Object> getEnglishWpn(String text) {
        return null;
    }

    @Override
    public List<Object> getChineseWpn(String text) {
        return null;
    }
}
