package kaitor.id.talkingenglish.level.model;

/**
 * Created by user pc on 6/12/2016.
 */
public class LipLevel {
    private String lip;
    private String question;
    private String translatedQuestion;
    private String[] answers;
    private int answerIndex;

    public String getLip() {
        return lip;
    }

    public void setLip(String lip) {
        this.lip = lip;
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
