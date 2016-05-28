package kaitor.id.talkingenglish.main;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user pc on 5/28/2016.
 */
public class Dictionary implements Parcelable {
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

    public Dictionary(String word){
        this.word = word;
    }

    public Dictionary(String word, String translation, String type){
        this.word = word;
        this.translation = translation;
        this.type = type;
    }

    public Dictionary(String word, String translation, String type, String lip, String hand){
        this.word = word;
        this.translation = translation;
        this.type = type;
        this.lip = lip;
        this.hand = hand;
    }

    public Dictionary(Parcel in){
        String[] data = new String[5];
        in.readStringArray(data);

        this.word = data[0];
        this.translation = data[1];
        this.type = data[2];
        this.lip = data[3];
        this.hand = data[4];
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[]{this.word,this.translation,this.type,this.lip,this.hand});
    }

    public class DictionaryCreator implements Parcelable.Creator<Dictionary> {

        @Override
        public Dictionary createFromParcel(Parcel source) {
            return new Dictionary(source);
        }

        @Override
        public Dictionary[] newArray(int size) {
            return new Dictionary[size];
        }

    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Dictionary createFromParcel(Parcel in) {
            return new Dictionary(in);
        }

        public Dictionary[] newArray(int size) {
            return new Dictionary[size];
        }
    };
}
