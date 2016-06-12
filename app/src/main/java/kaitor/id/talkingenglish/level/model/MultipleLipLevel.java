package kaitor.id.talkingenglish.level.model;

/**
 * Created by user pc on 6/12/2016.
 */
public class MultipleLipLevel {
    private String imageQuestion;
    private String[] imageAnswers;
    private int answerIndex;

    public String getImageQuestion() {
        return imageQuestion;
    }

    public void setImageQuestion(String imageQuestion) {
        this.imageQuestion = imageQuestion;
    }

    public String[] getImageAnswers() {
        return imageAnswers;
    }

    public void setImageAnswers(String[] imageAnswer) {
        this.imageAnswers = imageAnswer;
    }

    public int getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        this.answerIndex = answerIndex;
    }
}
