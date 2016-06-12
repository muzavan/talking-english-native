package kaitor.id.talkingenglish.level.model;

import android.os.Parcel;

/**
 * Created by user pc on 5/30/2016.
 */
public class MultipleLevel {
    private String question;
    private String translatedQuestion;
    private String[] answers = new String[4];
    private int answerIndex;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTranslatedQuestion() {
        return translatedQuestion;
    }

    public void setTranslatedQuestion(String translatedQuestion) {
        this.translatedQuestion = translatedQuestion;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }
}
