package zut.cs.nlp.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Result {
    private String tree;
    private String dependency;
    private List<Wpn> wpns;

    @Override
    public String toString() {
        return "Result{" +
                "tree='" + tree + '\'' +
                ", dependency='" + dependency + '\'' +
                ", wpns=" + wpns +
                '}';
    }

    public static class Wpn {
        private String word;
        private String pos;
        private String ne;

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getPos() {
            return pos;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        public String getNe() {
            return ne;
        }

        public void setNe(String ne) {
            this.ne = ne;
        }

        @Override
        public String toString() {
            return "Wpn{" +
                    "word='" + word + '\'' +
                    ", pos='" + pos + '\'' +
                    ", ne='" + ne + '\'' +
                    '}';
        }
    }
}

