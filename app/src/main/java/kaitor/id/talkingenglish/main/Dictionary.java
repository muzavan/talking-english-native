package kaitor.id.talkingenglish.main;

/**
 * Created by user pc on 5/28/2016.
 */
public class Dictionary {
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getLip() {
        return lip;
    }

    public void setLip(String lip) {
        this.lip = lip;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    private String word; // English word
    private String type; // Noun, verb, anything
    private String translation; // Indonesian Word
    private String lip; // Resource Name for Lips Reading
    private String hand; // Resource Name for Hand Gesture
}
