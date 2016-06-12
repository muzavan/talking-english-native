package kaitor.id.talkingenglish.level.model;

/**
 * Created by user pc on 5/30/2016.
 */
public class TypingLevel {
    private String question;
    private String translatedQuestion;
    private String answer;
    private String hand;

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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
