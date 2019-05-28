package zut.cs.core.nlp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "nlp", fallback = NlpFallback.class)
public interface NlpFeignClient {

    @RequestMapping(value = "/nlp_en/dependency", method = RequestMethod.POST)
    public String getEnglishDependency(@RequestParam("text") String text);

    @RequestMapping(value = "/nlp_ch/dependency", method = RequestMethod.POST)
    public String getChineseDependency(@RequestParam("text") String text);

    @RequestMapping(value = "/nlp_en/tree", method = RequestMethod.POST)
    public String getEnglishTree(@RequestParam("text") String text);

    @RequestMapping(value = "/nlp_ch/tree", method = RequestMethod.POST)
    public String getChineseTree(@RequestParam("text") String text);

    @RequestMapping(value = "/nlp_en/wpn", method = RequestMethod.POST)
    public List<Object> getEnglishWpn(@RequestParam("text") String text);

    @RequestMapping(value = "/nlp_ch/wpn", method = RequestMethod.POST)
    public List<Object> getChineseWpn(@RequestParam("text") String text);
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
