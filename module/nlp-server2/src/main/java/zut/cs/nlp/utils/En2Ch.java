package zut.cs.nlp.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class En2Ch {
    private Map<String, String> posMap = new HashMap<>();
    private Map<String, String> neMap = new HashMap<>();

    public En2Ch() {
        posMap.put(null, "未知");
        posMap.put("AD", "副词");
        posMap.put("AS", "体态词，体标记（例如：了，在，着，过）");
        posMap.put("BA", "把，将.的词性标记");
        posMap.put("CC", "并列连词，和");
        posMap.put("CD", "数字，一百");
        posMap.put("CS", "从属连词 （例子：若，如果，如…）");
        posMap.put("DEC", "的词性标记");
        posMap.put("DEG", "联结词的");
        posMap.put("DER", "得");
        posMap.put("DEV", "地");
        posMap.put("DT", "限定词，这");
        posMap.put("ETC", "等，等等");
        posMap.put("FW", "例子：ISO");
        posMap.put("IJ", "感叹词");
        posMap.put("JJ", "");
        posMap.put("LB", "例子：被，给");
        posMap.put("LC", "定位词，例子：里");
        posMap.put("M", "量词，例子：个");
        posMap.put("MSP", "例子：所");
        posMap.put("NN", "普通名词");
        posMap.put("NR", "专有名词");
        posMap.put("NT", "时序词，表示时间的名词");
        posMap.put("OD", "序数词，第一");
        posMap.put("ON", "拟声词，哈哈");
        posMap.put("P", "介词");
        posMap.put("PN", "代词");
        posMap.put("PU", "标点");
        posMap.put("SB", "例子：被，给");
        posMap.put("SP", "句尾小品词，吗");
        posMap.put("VA", "表语形容词，红");
        posMap.put("VC", "系动词，是");
        posMap.put("VE", "有");
        posMap.put("VV", "其他动词");
        posMap.put("ADJP", "形容词短语");
        posMap.put("ADVP", "由副词开头的副词短语");
        posMap.put("CLP", "量词短语");
        posMap.put("CP", "由补语引导的补语从句");
        posMap.put("DNP", "暂未分类");
        posMap.put("DP", "限定词短语");
        posMap.put("DVP", "暂未分类");
        posMap.put("FRAG", "暂未分类");
        posMap.put("IP", "暂未分类");
        posMap.put("LCP", "LC 位置词");
        posMap.put("LST", "列表标记，如--");
        posMap.put("NP", "名词短语");
        posMap.put("PP", "介词短语");
        posMap.put("PRN", "括号中的，插入的");
        posMap.put("QP", "量词短语");
        posMap.put("UCP", "非对等同位语短语");
        posMap.put("VP", "动词短语");
        posMap.put("VCD", "并列动词复合，例子：\n" +
                "(VCD (VV 观光) (VV 游览))");
        posMap.put("VCP", "动词+是，例子：\n" +
                "(VCP (VV 估计) (VC 为))");
        posMap.put("VNV", "(VNV (VV 看) (CD 一) (VV 看))\n" +
                "(VNV (VE 有) (AD 没) (VE 有))");
        posMap.put("VPT", "V-de-R, V不R\n" +
                "(VPT (VV 卖) (AD 不) (VV 完))\n" +
                "(VPT (VV 出) (DER 得) (VV 起))");
        posMap.put("VRD", "动词结果复合，\n" +
                "(VRD (VV 反映) (VV 出))\n" +
                "(VRD (VV 卖) (VV 完))");
        posMap.put("VSB", "定语+中心词\n" +
                "(VSB (VV 举债) (VV 扩张))");
        posMap.put("ADV", "副词的");
        posMap.put("APP", "同位的");
        posMap.put("BNF", "受益");
        posMap.put("CND", "条件");
        posMap.put("DIR", "方向");
        posMap.put("EXT", "范围");
        posMap.put("FOC", "副词");
        posMap.put("HLN", "标题");
        posMap.put("IJ", "插入语");
        posMap.put("IMP", "祈使句");
        posMap.put("IO", "间接宾语");
        posMap.put("LGS", "逻辑主语");
        posMap.put("LOC", "处所");
        posMap.put("MNR", "方式");
        posMap.put("OBJ", "直接宾语");
        posMap.put("PN", "专有名词");
        posMap.put("PRD", "谓词");
        posMap.put("PRP", "目的或理由");
        posMap.put("Q", "疑问");
        posMap.put("SBJ", "主语");
        posMap.put("SHORT", "缩略形式");
        posMap.put("TMP", "时间");
        posMap.put("TPC", "话题");
        posMap.put("TTL", "标题");
        posMap.put("WH", "Wh-短语");
        posMap.put("VOC", "呼格");
        posMap.put("*OP*", "在relative constructions相关结构中的操作符");
        posMap.put("*pro*", "丢掉的论元");
        posMap.put("*PRO*", "在受控结构中使用");
        posMap.put("*RNR*", "右部节点提升的空范畴");
        posMap.put("*T*", "A’移动的虚迹，话题化");
        posMap.put("*", "A移动的虚迹");
        posMap.put("*?*", "其他未知的空范畴");

        neMap.put("PERSON", "人名");
    }

    public Map<String, String> getPosMap() {
        return posMap;
    }

    public Map<String, String> getNeMap() {
        return neMap;
    }

    public String replacePos(String pos) {
        return posMap.get(pos);
    }


}
