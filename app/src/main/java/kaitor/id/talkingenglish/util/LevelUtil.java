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
    public static String[] BEGINNER_LEVELS = new String[]{"home","fruits","number","family"};
    public static String[] INTERMEDIATE_LEVELS = new String[]{"school","transportation","library","hobbies"};
    public static String[] ADVANCED_LEVELS = new String[]{"supermarket","factory","traffic","hospital"};

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
            BasicLevel basic1 = new BasicLevel();
            basic1.setWord("Teacher");
            basic1.setTranslation("Guru");
            basic1.setType("(noun) kata benda");
            basic1.setHand("gif/guru.gif");
            basic1.setLip("gif/teacher.gif");

            BasicLevel basic2 = new BasicLevel();
            basic1.setWord("Student");
            basic1.setTranslation("Murid");
            basic1.setType("(noun) kata benda");
            basic1.setHand("gif/murid.gif");
            basic1.setLip("gif/student.gif");

            MultipleLevel multiple1 = new MultipleLevel();
            multiple1.setQuestion("Which of these is 'the Teacher'?");
            multiple1.setTranslatedQuestion("Mana di bawah ini yang merupakan 'Guru'?");
            multiple1.setAnswers(new String[]{"drawable/teacher","drawable/doctor","drawable/student","drawable/chef"});
            multiple1.setAnswerIndex(0);

            MultipleLevel multiple2 = new MultipleLevel();
            multiple1.setQuestion("Which of these is 'the Student'?");
            multiple1.setTranslatedQuestion("Mana di bawah ini yang merupakan 'Murid'?");
            multiple1.setAnswers(new String[]{"drawable/chef","drawable/student","drawable/chef","drawable/teacher"});
            multiple1.setAnswerIndex(1);

            BasicLevel basic3 = new BasicLevel();
            basic1.setWord("Write");
            basic1.setTranslation("Tulis");
            basic1.setType("(verb) kata kerja");
            basic1.setHand("gif/tulis.gif");
            basic1.setLip("gif/write.gif");

            BasicLevel basic4 = new BasicLevel();
            basic1.setWord("Whiteboard");
            basic1.setTranslation("Papan Tulis");
            basic1.setType("(noun) kata benda");
            basic1.setHand("gif/papan_tulis.gif");
            basic1.setLip("gif/whiteboard.gif");

            BasicLevel basic5 = new BasicLevel();
            basic1.setWord("The teacher is writing on a whiteboard");
            basic1.setTranslation("Guru itu sedang menulis di papan tulis");
            basic1.setType("");
            basic1.setHand("gif/guru_sedang_tulis.gif");
            basic1.setLip("gif/the_teacher_is_writing.gif");

            BlankLevel blank1 = new BlankLevel();
            blank1.setQuestion("The teacher is *** on a whiteboard");
            blank1.setTranslatedQuestion("Guru itu sedang menulis di papan tulis");
            blank1.setHand("gif/guru_sedang_tulis.gif");
            blank1.setAnswers(new String[]{"watching","reading","writing","speaking","looking"});
            blank1.setAnswerIndex(2);

            LipLevel lip1 = new LipLevel();
            lip1.setQuestion("What is the pronounciation about?");
            lip1.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip1.setLip("gif/write.gif");
            lip1.setAnswers(new String[]{"Watch","Write","Look","Learn"});
            lip1.setAnswerIndex(1);

            BlankLevel blank2 = new BlankLevel();
            blank1.setQuestion("The teacher is writing on a ***");
            blank1.setTranslatedQuestion("Guru itu sedang menulis di papan tulis");
            blank1.setHand("gif/guru_sedang_tulis.gif");
            blank1.setAnswers(new String[]{"paper","book","whiteboard","wall","table"});
            blank1.setAnswerIndex(2);

            LipLevel lip2 = new LipLevel();
            lip1.setQuestion("What is the pronounciation about?");
            lip1.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip1.setLip("gif/whiteboard.gif");
            lip1.setAnswers(new String[]{"Paper","Tabel","Wall","Whiteboard"});
            lip1.setAnswerIndex(3);

            BasicLevel basic6 = new BasicLevel();
            basic1.setWord("Pay attention");
            basic1.setTranslation("Perhatikan");
            basic1.setType("(verb) kata kerja");
            basic1.setHand("gif/lihat.gif");
            basic1.setLip("gif/pay_attention.gif");

            BasicLevel basic7 = new BasicLevel();
            basic1.setWord("The students are paying attention to their teacher");
            basic1.setTranslation("Murid-murid sedang memperhatikan gurunya");
            basic1.setType("");
            basic1.setHand("gif/murid_lihat_guru.gif");
            basic1.setLip("gif/pay_attention.gif");

            BlankLevel blank3 = new BlankLevel();
            blank1.setQuestion("The students *** *** attention to their teacher");
            blank1.setTranslatedQuestion("Murid-murid sedang memperhatikan gurunya");
            blank1.setHand("gif/murid_lihat_guru.gif");
            blank1.setAnswers(new String[]{"is paying","are looking","are paying","is learning","is looking"});
            blank1.setAnswerIndex(2);

            BlankLevel blank4 = new BlankLevel();
            blank1.setQuestion("The students are paying *** to their teacher");
            blank1.setTranslatedQuestion("Murid-murid sedang memperhatikan gurunya");
            blank1.setHand("gif/murid_lihat_guru.gif");
            blank1.setAnswers(new String[]{"attention","study","thinking","learn","borrow"});
            blank1.setAnswerIndex(0);

            LipLevel lip3 = new LipLevel();
            lip1.setQuestion("What is the pronounciation about?");
            lip1.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip1.setLip("gif/pay_attention.gif");
            lip1.setAnswers(new String[]{"Pay learn","Pay study","Pay attention","Pay thinking"});
            lip1.setAnswerIndex(2);

            LipLevel lip4 = new LipLevel();
            lip1.setQuestion("What is the pronounciation about?");
            lip1.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip1.setLip("gif/student.gif");
            lip1.setAnswers(new String[]{"Student","Teacher","Doctor","Chef"});
            lip1.setAnswerIndex(0);

            LipLevel lip5 = new LipLevel();
            lip1.setQuestion("What is the pronounciation about?");
            lip1.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip1.setLip("gif/teacher.gif");
            lip1.setAnswers(new String[]{"Doctor","Student","Chef","Teacher"});
            lip1.setAnswerIndex(3);

            MultipleLevel multiple3 = new MultipleLevel();
            multiple1.setQuestion("Which of these is 'study'?");
            multiple1.setTranslatedQuestion("Mana di bawah ini yang merupakan 'belajar'?");
            multiple1.setAnswers(new String[]{"drawable/eating","drawable/watching","drawable/study","drawable/basketball"});
            multiple1.setAnswerIndex(2);

            BasicLevel basic8 = new BasicLevel();
            basic1.setWord("Study");
            basic1.setTranslation("Belajar");
            basic1.setType("(verb) kata kerja");
            basic1.setHand("gif/belajar.gif");
            basic1.setLip("gif/study.gif");

            BasicLevel basic9 = new BasicLevel();
            basic1.setWord("I studied History yesterday");
            basic1.setTranslation("Saya belajar Sejarah kemarin");
            basic1.setType("");
            basic1.setHand("gif/saya_belajar_sejarah.gif");
            basic1.setLip("gif/i_study_history.gif");

            BlankLevel blank5 = new BlankLevel();
            blank1.setQuestion("I *** History yesterday");
            blank1.setTranslatedQuestion("Saya belajar Sejarah kemarin");
            blank1.setHand("gif/saya_belajar_sejarah.gif");
            blank1.setAnswers(new String[]{"studied","read","watched","borrowed","heard"});
            blank1.setAnswerIndex(0);

            BasicLevel basic10 = new BasicLevel();
            basic1.setWord("The students will study Math tomorrow");
            basic1.setTranslation("Murid-murid akan belajar Matematika besok");
            basic1.setType("");
            basic1.setHand("gif/murid_akan_belajar.gif");
            basic1.setLip("gif/student_will_study.gif");

            BlankLevel blank6 = new BlankLevel();
            blank1.setQuestion("The students *** *** Math tomorrow");
            blank1.setTranslatedQuestion("Murid-murid akan belajar Matematika besok");
            blank1.setHand("gif/murid_akan_belajar.gif");
            blank1.setAnswers(new String[]{"are study","is study","will study","will studied","is studied"});
            blank1.setAnswerIndex(2);

            LipLevel lip6 = new LipLevel();
            lip1.setQuestion("What is the pronounciation about?");
            lip1.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip1.setLip("gif/study.gif");
            lip1.setAnswers(new String[]{"Borrow","Learn","Read","Study"});
            lip1.setAnswerIndex(3);

            
            LevelFragment frag0 = BasicFragment.newInstance(basic1);
            levels.add(frag0);
            LevelFragment frag1 = BasicFragment.newInstance(basic2);
            levels.add(frag1);
            LevelFragment frag2 = MultipleFragment.newInstance(multiple1);
            levels.add(frag2);
            LevelFragment frag3 = MultipleFragment.newInstance(multiple2);
            levels.add(frag3);
            LevelFragment frag4 = BasicFragment.newInstance(basic3);
            levels.add(frag4);
            LevelFragment frag5 = BasicFragment.newInstance(basic4);
            levels.add(frag5);
            LevelFragment frag6 = BasicFragment.newInstance(basic5);
            levels.add(frag6);
            LevelFragment frag7 = BlankFragment.newInstance(blank1);
            levels.add(frag7);
            LevelFragment frag8 = LipFragment.newInstance(lip1);
            levels.add(frag8);
            LevelFragment frag9 = BlankFragment.newInstance(blank2);
            levels.add(frag9);
            LevelFragment frag10 = LipFragment.newInstance(lip2);
            levels.add(frag10);
            LevelFragment frag11 = BasicFragment.newInstance(basic6);
            levels.add(frag11);
            LevelFragment frag12 = BasicFragment.newInstance(basic7);
            levels.add(frag12);
            LevelFragment frag13 = BlankFragment.newInstance(blank3);
            levels.add(frag13);
            LevelFragment frag14 = BlankFragment.newInstance(blank4);
            levels.add(frag14);
            LevelFragment frag15 = LipFragment.newInstance(lip3);
            levels.add(frag15);
            LevelFragment frag16 = LipFragment.newInstance(lip4);
            levels.add(frag16);
            LevelFragment frag17 = LipFragment.newInstance(lip5);
            levels.add(frag17);
            LevelFragment frag18 = BasicFragment.newInstance(basic8);
            levels.add(frag18);
            LevelFragment frag19 = MultipleFragment.newInstance(multiple3);
            levels.add(frag19);
            LevelFragment frag20 = BasicFragment.newInstance(basic9);
            levels.add(frag20);
            LevelFragment frag21 = BlankFragment.newInstance(blank5);
            levels.add(frag21);
            LevelFragment frag22 = BasicFragment.newInstance(basic10);
            levels.add(frag22);
            LevelFragment frag23 = BlankFragment.newInstance(blank6);
            levels.add(frag23);
            LevelFragment frag24 = LipFragment.newInstance(lip6);
            levels.add(frag24);

        } else if(topic.equalsIgnoreCase("supermarket")){

        }

    }

    public ArrayList<LevelFragment> getLevels(){
        return levels;
    }
}
