package kaitor.id.talkingenglish.level.model;

/**
 * Created by user pc on 5/30/2016.
 */
public class BasicLevel {
    private String word; // English word
    private String type; // Noun, verb, anything
    private String lip; // Resource Name for Lips Reading
    private String translation;

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

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

    public String getLip() {
        return lip;
    }

    public void setLip(String lip) {
        this.lip = lip;
    }
}
