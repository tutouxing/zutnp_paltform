package zut.cs.nlp.example;

import edu.stanford.nlp.dcoref.CorefChain;
import edu.stanford.nlp.dcoref.CorefCoreAnnotations;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import zut.cs.nlp.bean.Result;
import zut.cs.nlp.utils.En2Ch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StanfordChineseNlpExample {

    private Result result = new Result();
    private En2Ch en2Ch = new En2Ch();

    public static void main(String[] args) {
        StanfordChineseNlpExample nlp = new StanfordChineseNlpExample();
        Result result = nlp.runChineseAnnotators("\"袁隆平是中国科学院的院士,他于2009年10月到中国山东省东营市东营区永乐机场附近承包了一千亩盐碱地,\"\n" +
                "                + \"开始种植棉花, 年产量达到一万吨, 哈哈, 反正棣琦说的是假的,逗你玩儿,明天下午2点来我家吃饭吧。\"\n" +
                "                + \"棣琦是山东大学毕业的,目前在百度做java开发,位置是东北旺东路102号院,手机号14366778890\";");
        System.out.println(result);

    }

    public Result runChineseAnnotators(String text) {

        Annotation document = new Annotation(text);
        StanfordCoreNLP corenlp = new StanfordCoreNLP("StanfordCoreNLP-chinese.properties");
        corenlp.annotate(document);
        return parserOutput(document);
    }

    public Result parserOutput(Annotation document) {
        // these are all the sentences in this document
        // a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        List<Result.Wpn> wpns = new ArrayList<>();

        for (CoreMap sentence : sentences) {
            // traversing the words in the current sentence
            // a CoreLabel is a CoreMap with additional token-specific methods
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                // this is the text of the token
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                // this is the POS tag of the token
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                // this is the NER label of the token
                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                Result.Wpn wpn = new Result.Wpn();
                wpn.setWord(word);
                wpn.setPos(pos);
                wpn.setNe(ne);
                wpns.add(wpn);
                result.setWpns(wpns);
            }

            // this is the parse tree of the current sentence
            Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
            result.setTree(tree.toString());

            // this is the Stanford dependency graph of the current sentence
            SemanticGraph dependencies = sentence.get(SemanticGraphCoreAnnotations.CollapsedCCProcessedDependenciesAnnotation.class);
            result.setDependency(dependencies.toString());
        }

        // This is the coreference link graph
        // Each chain stores a set of mentions that link to each other,
        // along with a method for getting the most representative mention
        // Both sentence and token offsets start at 1!
        Map<Integer, CorefChain> graph =
                document.get(CorefCoreAnnotations.CorefChainAnnotation.class);
        return result;
    }
}
