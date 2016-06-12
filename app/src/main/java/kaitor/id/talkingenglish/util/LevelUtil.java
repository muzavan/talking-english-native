package kaitor.id.talkingenglish.util;

import java.util.ArrayList;
import java.util.logging.Level;

import kaitor.id.talkingenglish.level.fragment.BasicFragment;
import kaitor.id.talkingenglish.level.fragment.BlankFragment;
import kaitor.id.talkingenglish.level.fragment.LevelFragment;
import kaitor.id.talkingenglish.level.fragment.LipFragment;
import kaitor.id.talkingenglish.level.fragment.MultipleFragment;
import kaitor.id.talkingenglish.level.fragment.TypingFragment;
import kaitor.id.talkingenglish.level.model.BasicLevel;
import kaitor.id.talkingenglish.level.model.BlankLevel;
import kaitor.id.talkingenglish.level.model.LipLevel;
import kaitor.id.talkingenglish.level.model.MultipleLevel;
import kaitor.id.talkingenglish.level.model.TypingLevel;

/**
 * Created by user pc on 6/12/2016.
 */
public class LevelUtil {
    private ArrayList<LevelFragment> levels = new ArrayList<>();

    public LevelUtil(String topic){
        if(topic.equalsIgnoreCase("home")){
            BasicLevel basic1 = new BasicLevel();
            basic1.setWord("Mother");
            basic1.setTranslation("Ibu");
            basic1.setType("(noun) kata benda");
            basic1.setHand("gif/ibu_sl.gif");
            basic1.setLip("gif/mother.gif");

            MultipleLevel multiple1 = new MultipleLevel();
            multiple1.setQuestion("Which of these is 'the Mother'?");
            multiple1.setTranslatedQuestion("Mana di bawah ini yang merupakan 'Ibu'?");
            multiple1.setAnswers(new String[]{"drawable/father_avatar","drawable/son_avatar","drawable/mother_avatar","drawable/daughter_avatar"});
            multiple1.setAnswerIndex(2);

            BasicLevel basic2 = new BasicLevel();
            basic1.setWord("Father");
            basic1.setTranslation("Ayah");
            basic1.setType("(noun) kata benda");
            basic1.setHand("gif/ayah_sl.gif");
            basic1.setLip("gif/father.gif");

            MultipleLevel multiple2 = new MultipleLevel();
            multiple1.setQuestion("Which of these is 'the Father'?");
            multiple1.setTranslatedQuestion("Mana di bawah ini yang merupakan 'Ayah'?");
            multiple1.setAnswers(new String[]{"drawable/daughter_avatar","drawable/mother_avatar","drawable/son_avatar","drawable/father_avatar"});
            multiple1.setAnswerIndex(3);

            BasicLevel basic3 = new BasicLevel();
            basic1.setWord("She is a mother");
            basic1.setTranslation("Dia adalah seorang ibu");
            basic1.setType("");
            basic1.setHand("gif/dia_ibu_sl.gif");
            basic1.setLip("gif/she_is_a_mother.gif");

            BlankLevel blank1 = new BlankLevel();
            blank1.setQuestion("She *** a mother");
            blank1.setTranslatedQuestion("Dia adalah seorang ibu");
            blank1.setHand("gif/dia_ibu_sl.gif");
            blank1.setAnswers(new String[]{"am","are","is","she","it"});
            blank1.setAnswerIndex(3);

            TypingLevel typing1 = new TypingLevel();
            typing1.setQuestion("She is a ***");
            typing1.setTranslatedQuestion("Dia adalah seorang ibu");
            typing1.setHand("gif/dia_ibu_sl.gif");
            typing1.setAnswer("mother");

            BasicLevel basic4 = new BasicLevel();
            basic1.setWord("He is a father");
            basic1.setTranslation("Dia adalah seorang ayah");
            basic1.setType("");
            basic1.setHand("gif/dia_ayah_sl.gif");
            basic1.setLip("gif/he_is_a_father.gif");

            BlankLevel blank2 = new BlankLevel();
            blank1.setQuestion("*** is a father");
            blank1.setTranslatedQuestion("Dia adalah seorang ayah");
            blank1.setHand("gif/dia_ayah_sl.gif");
            blank1.setAnswers(new String[]{"She","He","They","It","His"});
            blank1.setAnswerIndex(1);

            TypingLevel typing2 = new TypingLevel();
            typing1.setQuestion("Hhe is a ***");
            typing1.setTranslatedQuestion("Dia adalah seorang ayah");
            typing1.setHand("gif/dia_ayah_sl.gif");
            typing1.setAnswer("father");

            LipLevel lip1 = new LipLevel();
            lip1.setQuestion("What is the pronounciation about?");
            lip1.setTranslatedQuestion("Apa kalimat yang diucapkan?");
            lip1.setLip("gif/she_is_a_mother.gif");
            lip1.setAnswers(new String[]{"He are a mother","She is a mother","She are a mother","He is a father"});
            lip1.setAnswerIndex(1);

            LipLevel lip2 = new LipLevel();
            lip1.setQuestion("What is the pronounciation about?");
            lip1.setTranslatedQuestion("Apa kalimat yang diucapkan?");
            lip1.setLip("gif/he_is_a_father.gif");
            lip1.setAnswers(new String[]{"She is a mother","He is a mother","He is a father","He are a father"});
            lip1.setAnswerIndex(2);

            BasicLevel basic5 = new BasicLevel();
            basic1.setWord("Brother");
            basic1.setTranslation("Saudara laki-laki");
            basic1.setType("(noun) kata benda");
            basic1.setHand("gif/saudara_laki_sl.gif");
            basic1.setLip("gif/brother.gif");

            BasicLevel basic6 = new BasicLevel();
            basic1.setWord("Sister");
            basic1.setTranslation("Saudara perempuan");
            basic1.setType("(noun) kata benda");
            basic1.setHand("gif/saudara_perempuan_sl.gif");
            basic1.setLip("gif/sister.gif");

            MultipleLevel multiple3 = new MultipleLevel();
            multiple1.setQuestion("Which of these is 'the Brother'?");
            multiple1.setTranslatedQuestion("Mana di bawah ini yang merupakan 'Saudara laki-laki'?");
            multiple1.setAnswers(new String[]{"drawable/father_avatar","drawable/son_avatar","drawable/mother_avatar","drawable/daughter_avatar"});
            multiple1.setAnswerIndex(1);

            MultipleLevel multiple4 = new MultipleLevel();
            multiple1.setQuestion("Which of these is 'the Sister'?");
            multiple1.setTranslatedQuestion("Mana di bawah ini yang merupakan 'Saudara perempuan'?");
            multiple1.setAnswers(new String[]{"drawable/mother_avatar","drawable/father_avatar","drawable/daughter_avatar","drawable/son_avatar"});
            multiple1.setAnswerIndex(2);

            BasicLevel basic7 = new BasicLevel();
            basic1.setWord("Watch");
            basic1.setTranslation("Menonton");
            basic1.setType("(verb) kata kerja");
            basic1.setHand("gif/lihat.gif");
            basic1.setLip("gif/watch.gif");

            BasicLevel basic8 = new BasicLevel();
            basic1.setWord("My brother is watching television");
            basic1.setTranslation("Saudara laki-laki saya sedang menonton televisi");
            basic1.setType("");
            basic1.setHand("gif/saudara_tonton_tv_sl.gif");
            basic1.setLip("gif/my_brother_is_watching_tv");

            BlankLevel blank3 = new BlankLevel();
            blank1.setQuestion("My brother *** watching television");
            blank1.setTranslatedQuestion("Saudara laki-laki saya sedang menonton televisi");
            blank1.setHand("gif/saudara_tonton_tv_sl.gif");
            blank1.setAnswers(new String[]{"Are","Is","It","Were","Was"});
            blank1.setAnswerIndex(1);

            LipLevel lip3 = new LipLevel();
            lip1.setQuestion("What is the pronounciation about?");
            lip1.setTranslatedQuestion("Apa kalimat yang diucapkan?");
            lip1.setLip("gif/watch");
            lip1.setAnswers(new String[]{"Watch","Read","Eat","Sleep"});
            lip1.setAnswerIndex(0);

            LevelFragment frag0 = BasicFragment.newInstance(basic1);
            levels.add(frag0);
            LevelFragment frag1 = MultipleFragment.newInstance(multiple1);
            levels.add(frag1);
            LevelFragment frag2 = BasicFragment.newInstance(basic2);
            levels.add(frag2);
            LevelFragment frag3 = MultipleFragment.newInstance(multiple2);
            levels.add(frag3);
            LevelFragment frag4 = BasicFragment.newInstance(basic3);
            levels.add(frag4);
            LevelFragment frag5 = BlankFragment.newInstance(blank1);
            levels.add(frag5);
            LevelFragment frag6 = TypingFragment.newInstance(typing1);
            levels.add(frag6);
            LevelFragment frag7 = BasicFragment.newInstance(basic4);
            levels.add(frag7);
            LevelFragment frag8 = BlankFragment.newInstance(blank2);
            levels.add(frag8);
            LevelFragment frag9 = TypingFragment.newInstance(typing2);
            levels.add(frag9);
            LevelFragment frag10 = LipFragment.newInstance(lip1);
            levels.add(frag10);
            LevelFragment frag11 = LipFragment.newInstance(lip2);
            levels.add(frag11);
            LevelFragment frag12 = BasicFragment.newInstance(basic5);
            levels.add(frag12);
            LevelFragment frag13 = BasicFragment.newInstance(basic6);
            levels.add(frag13);
            LevelFragment frag14 = MultipleFragment.newInstance(multiple3);
            levels.add(frag14);
            LevelFragment frag15 = MultipleFragment.newInstance(multiple4);
            levels.add(frag15);
            LevelFragment frag16 = BasicFragment.newInstance(basic7);
            levels.add(frag16);
            LevelFragment frag17 = BasicFragment.newInstance(basic8);
            levels.add(frag17);
            LevelFragment frag18 = BlankFragment.newInstance(blank3);
            levels.add(frag18);
            LevelFragment frag19 = LipFragment.newInstance(lip3);
            levels.add(frag19);
            

        }
        else if(topic.equalsIgnoreCase("fruits")){

        } else if(topic.equalsIgnoreCase("number")){

        } else if(topic.equalsIgnoreCase("transportation")){

        } else if(topic.equalsIgnoreCase("library")){

        } else if(topic.equalsIgnoreCase("hobbies")){

        } else if(topic.equalsIgnoreCase("factory")){

        } else if(topic.equalsIgnoreCase("hospital")){

        } else if(topic.equalsIgnoreCase("traffic")){

        } else if(topic.equalsIgnoreCase("family")){

        } else if(topic.equalsIgnoreCase("school")){

        } else if(topic.equalsIgnoreCase("supermarket")){

        }

    }

    private ArrayList<LevelFragment> getLevels(){
        return levels;
    }
}
