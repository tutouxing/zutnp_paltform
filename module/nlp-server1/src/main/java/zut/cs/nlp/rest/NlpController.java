package zut.cs.nlp.rest;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zut.cs.nlp.bean.Result;
import zut.cs.nlp.example.StanfordChineseNlpExample;
import zut.cs.nlp.example.StanfordEnglishNlp;

import java.util.List;

@RestController
public class NlpController {
    StanfordChineseNlpExample chineseNlp = new StanfordChineseNlpExample();
    StanfordEnglishNlp englishNlp = new StanfordEnglishNlp();

    @ApiOperation(value = "处理英文，得到依赖关系")
    @PostMapping("/nlp_en/dependency")
    public String getEnDep(@RequestBody String text) {
        System.out.println(text);
        Result result = englishNlp.runAllAnnotators(text);
        return result.getDependency();
    }

    @ApiOperation(value = "处理英文，得到词性分析和标注")
    @PostMapping("/nlp_en/wpn")
    public List<Result.Wpn> getEnWpn(@RequestBody String text) {
        Result result = englishNlp.runAllAnnotators(text);
        return result.getWpns();
    }

    @ApiOperation(value = "处理英文，得到语法树")
    @PostMapping("/nlp_en/tree")
    public String getEnTree(@RequestBody String text) {
        Result result = englishNlp.runAllAnnotators(text);
        return result.getTree();
    }

    @ApiOperation(value = "处理中文，得到依赖关系")
    @PostMapping("/nlp_ch/dependency")
    public String handleCh(@RequestBody String text) {
        Result result = chineseNlp.runChineseAnnotators(text);
        return result.getDependency();
    }

    @ApiOperation(value = "处理中文，得到词性分析和标注")
    @PostMapping("/nlp_ch/wpn")
    public List<Result.Wpn> getChWpn(@RequestBody String text) {
        Result result = chineseNlp.runChineseAnnotators(text);
        return result.getWpns();
    }

    @ApiOperation(value = "处理中文，得到语法树")
    @PostMapping("/nlp_ch/tree")
    public String getChTree(@RequestBody String text) {
        Result result = chineseNlp.runChineseAnnotators(text);
        return result.getTree();
    }
}
