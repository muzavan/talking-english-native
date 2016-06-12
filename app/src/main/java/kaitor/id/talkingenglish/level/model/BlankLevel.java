package kaitor.id.talkingenglish.level.model;

/**
 * Created by user pc on 5/30/2016.
 */
public class BlankLevel {
    private String question;
    private String translatedQuestion;
    private String hand;
    private String[] answers;
    private int answerIndex;

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

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
