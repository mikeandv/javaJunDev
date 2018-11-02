package lessons.lesson_7.homework.examtask;

import java.util.Arrays;

public class Pupil {

    private int id;
    private ExamResult[] examResults;

    /*
    * Консутруктор
     */
    public Pupil(int id) {
        this.id = id;
    }

    /*
    * Вложенный класс
     */
    public class ExamResult {
        String examLabel;
        int mark;
        String exStatus;

        public ExamResult(String examLabel, int mark) {
            this.examLabel = examLabel;
            this.mark = mark;
            this.exStatus = markDecision(this.mark);
        }

        public String markDecision(int mark) {

            if (mark >=3)
                return "сдал";
            else
                return "не сдал";
        }

        public String getExamLabel() {
            return examLabel;
        }

        public String getExStatus() {
            return exStatus;
        }
    }

    public void setExams (String[] ex, int[] marks) {
        this.examResults = new ExamResult[ex.length];

        for (int i = 0; i < ex.length; i++) {
            this.examResults[i] = new ExamResult(ex[i], marks[i]);

        }
    }

    @Override
    public String toString() {
        String st;
        st = "Студент: " + id + "\n";
        for (int i = 0; i < this.examResults.length; i++) {
            st += examResults[i].getExamLabel() + " " + examResults[i].getExStatus() + "\n";
        }

        return st;
    }
}
