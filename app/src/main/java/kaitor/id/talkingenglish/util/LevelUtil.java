package kaitor.id.talkingenglish.util;

import java.util.ArrayList;
import java.util.logging.Level;

import kaitor.id.talkingenglish.level.fragment.BasicFragment;
import kaitor.id.talkingenglish.level.fragment.BlankFragment;
import kaitor.id.talkingenglish.level.fragment.DialogueFragment;
import kaitor.id.talkingenglish.level.fragment.LevelFragment;
import kaitor.id.talkingenglish.level.fragment.LipFragment;
import kaitor.id.talkingenglish.level.fragment.MultipleFragment;
import kaitor.id.talkingenglish.level.fragment.MultipleTextFragment;
import kaitor.id.talkingenglish.level.fragment.TextFragment;
import kaitor.id.talkingenglish.level.fragment.TypingFragment;
import kaitor.id.talkingenglish.level.model.BasicLevel;
import kaitor.id.talkingenglish.level.model.BlankLevel;
import kaitor.id.talkingenglish.level.model.DialogueLevel;
import kaitor.id.talkingenglish.level.model.LipLevel;
import kaitor.id.talkingenglish.level.model.MultipleLevel;
import kaitor.id.talkingenglish.level.model.MultipleTextLevel;
import kaitor.id.talkingenglish.level.model.TextLevel;
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
            basic2.setWord("Father");
            basic2.setTranslation("Ayah");
            basic2.setType("(noun) kata benda");
            basic2.setHand("gif/ayah_sl.gif");
            basic2.setLip("gif/father.gif");

            MultipleLevel multiple2 = new MultipleLevel();
            multiple2.setQuestion("Which of these is 'the Father'?");
            multiple2.setTranslatedQuestion("Mana di bawah ini yang merupakan 'Ayah'?");
            multiple2.setAnswers(new String[]{"drawable/daughter_avatar","drawable/mother_avatar","drawable/son_avatar","drawable/father_avatar"});
            multiple2.setAnswerIndex(3);

            BasicLevel basic3 = new BasicLevel();
            basic3.setWord("She is a mother");
            basic3.setTranslation("Dia adalah seorang ibu");
            basic3.setType("");
            basic3.setHand("gif/dia_ibu_sl.gif");
            basic3.setLip("gif/she_is_a_mother.gif");

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
            basic4.setWord("He is a father");
            basic4.setTranslation("Dia adalah seorang ayah");
            basic4.setType("");
            basic4.setHand("gif/dia_ayah_sl.gif");
            basic4.setLip("gif/he_is_a_father.gif");

            BlankLevel blank2 = new BlankLevel();
            blank2.setQuestion("*** is a father");
            blank2.setTranslatedQuestion("Dia adalah seorang ayah");
            blank2.setHand("gif/dia_ayah_sl.gif");
            blank2.setAnswers(new String[]{"She","He","They","It","His"});
            blank2.setAnswerIndex(1);

            TypingLevel typing2 = new TypingLevel();
            typing2.setQuestion("Hhe is a ***");
            typing2.setTranslatedQuestion("Dia adalah seorang ayah");
            typing2.setHand("gif/dia_ayah_sl.gif");
            typing2.setAnswer("father");

            LipLevel lip1 = new LipLevel();
            lip1.setQuestion("What is the pronounciation about?");
            lip1.setTranslatedQuestion("Apa kalimat yang diucapkan?");
            lip1.setLip("gif/she_is_a_mother.gif");
            lip1.setAnswers(new String[]{"He are a mother","She is a mother","She are a mother","He is a father"});
            lip1.setAnswerIndex(1);

            LipLevel lip2 = new LipLevel();
            lip2.setQuestion("What is the pronounciation about?");
            lip2.setTranslatedQuestion("Apa kalimat yang diucapkan?");
            lip2.setLip("gif/he_is_a_father.gif");
            lip2.setAnswers(new String[]{"She is a mother","He is a mother","He is a father","He are a father"});
            lip2.setAnswerIndex(2);

            BasicLevel basic5 = new BasicLevel();
            basic5.setWord("Brother");
            basic5.setTranslation("Saudara laki-laki");
            basic5.setType("(noun) kata benda");
            basic5.setHand("gif/saudara_laki_sl.gif");
            basic5.setLip("gif/brother.gif");

            BasicLevel basic6 = new BasicLevel();
            basic6.setWord("Sister");
            basic6.setTranslation("Saudara perempuan");
            basic6.setType("(noun) kata benda");
            basic6.setHand("gif/saudara_perempuan_sl.gif");
            basic6.setLip("gif/sister.gif");

            MultipleLevel multiple3 = new MultipleLevel();
            multiple3.setQuestion("Which of these is 'the Brother'?");
            multiple3.setTranslatedQuestion("Mana di bawah ini yang merupakan 'Saudara laki-laki'?");
            multiple3.setAnswers(new String[]{"drawable/father_avatar","drawable/son_avatar","drawable/mother_avatar","drawable/daughter_avatar"});
            multiple3.setAnswerIndex(1);

            MultipleLevel multiple4 = new MultipleLevel();
            multiple4.setQuestion("Which of these is 'the Sister'?");
            multiple4.setTranslatedQuestion("Mana di bawah ini yang merupakan 'Saudara perempuan'?");
            multiple4.setAnswers(new String[]{"drawable/mother_avatar","drawable/father_avatar","drawable/daughter_avatar","drawable/son_avatar"});
            multiple4.setAnswerIndex(2);

            BasicLevel basic7 = new BasicLevel();
            basic7.setWord("Watch");
            basic7.setTranslation("Menonton");
            basic7.setType("(verb) kata kerja");
            basic7.setHand("gif/lihat.gif");
            basic7.setLip("gif/watch.gif");

            BasicLevel basic8 = new BasicLevel();
            basic8.setWord("My brother is watching television");
            basic8.setTranslation("Saudara laki-laki saya sedang menonton televisi");
            basic8.setType("");
            basic8.setHand("gif/saudara_tonton_tv_sl.gif");
            basic8.setLip("gif/my_brother_is_watching_tv");

            BlankLevel blank3 = new BlankLevel();
            blank3.setQuestion("My brother *** watching television");
            blank3.setTranslatedQuestion("Saudara laki-laki saya sedang menonton televisi");
            blank3.setHand("gif/saudara_tonton_tv_sl.gif");
            blank3.setAnswers(new String[]{"Are","Is","It","Were","Was"});
            blank3.setAnswerIndex(1);

            LipLevel lip3 = new LipLevel();
            lip3.setQuestion("What is the pronounciation about?");
            lip3.setTranslatedQuestion("Apa kalimat yang diucapkan?");
            lip3.setLip("gif/watch");
            lip3.setAnswers(new String[]{"Watch","Read","Eat","Sleep"});
            lip3.setAnswerIndex(0);

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
            basic2.setWord("Student");
            basic2.setTranslation("Murid");
            basic2.setType("(noun) kata benda");
            basic2.setHand("gif/murid.gif");
            basic2.setLip("gif/student.gif");

            MultipleLevel multiple1 = new MultipleLevel();
            multiple1.setQuestion("Which of these is 'the Teacher'?");
            multiple1.setTranslatedQuestion("Mana di bawah ini yang merupakan 'Guru'?");
            multiple1.setAnswers(new String[]{"drawable/teacher","drawable/doctor","drawable/student","drawable/chef"});
            multiple1.setAnswerIndex(0);

            MultipleLevel multiple2 = new MultipleLevel();
            multiple2.setQuestion("Which of these is 'the Student'?");
            multiple2.setTranslatedQuestion("Mana di bawah ini yang merupakan 'Murid'?");
            multiple2.setAnswers(new String[]{"drawable/chef","drawable/student","drawable/chef","drawable/teacher"});
            multiple2.setAnswerIndex(1);

            BasicLevel basic3 = new BasicLevel();
            basic3.setWord("Write");
            basic3.setTranslation("Tulis");
            basic3.setType("(verb) kata kerja");
            basic3.setHand("gif/tulis.gif");
            basic3.setLip("gif/write.gif");

            BasicLevel basic4 = new BasicLevel();
            basic4.setWord("Whiteboard");
            basic4.setTranslation("Papan Tulis");
            basic4.setType("(noun) kata benda");
            basic4.setHand("gif/papan_tulis.gif");
            basic4.setLip("gif/whiteboard.gif");

            BasicLevel basic5 = new BasicLevel();
            basic5.setWord("The teacher is writing on a whiteboard");
            basic5.setTranslation("Guru itu sedang menulis di papan tulis");
            basic5.setType("");
            basic5.setHand("gif/guru_sedang_tulis.gif");
            basic5.setLip("gif/the_teacher_is_writing.gif");

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
            blank2.setQuestion("The teacher is writing on a ***");
            blank2.setTranslatedQuestion("Guru itu sedang menulis di papan tulis");
            blank2.setHand("gif/guru_sedang_tulis.gif");
            blank2.setAnswers(new String[]{"paper","book","whiteboard","wall","table"});
            blank2.setAnswerIndex(2);

            LipLevel lip2 = new LipLevel();
            lip2.setQuestion("What is the pronounciation about?");
            lip2.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip2.setLip("gif/whiteboard.gif");
            lip2.setAnswers(new String[]{"Paper","Tabel","Wall","Whiteboard"});
            lip2.setAnswerIndex(3);

            BasicLevel basic6 = new BasicLevel();
            basic6.setWord("Pay attention");
            basic6.setTranslation("Perhatikan");
            basic6.setType("(verb) kata kerja");
            basic6.setHand("gif/lihat.gif");
            basic6.setLip("gif/pay_attention.gif");

            BasicLevel basic7 = new BasicLevel();
            basic7.setWord("The students are paying attention to their teacher");
            basic7.setTranslation("Murid-murid sedang memperhatikan gurunya");
            basic7.setType("");
            basic7.setHand("gif/murid_lihat_guru.gif");
            basic7.setLip("gif/pay_attention.gif");

            BlankLevel blank3 = new BlankLevel();
            blank3.setQuestion("The students *** *** attention to their teacher");
            blank3.setTranslatedQuestion("Murid-murid sedang memperhatikan gurunya");
            blank3.setHand("gif/murid_lihat_guru.gif");
            blank3.setAnswers(new String[]{"is paying","are looking","are paying","is learning","is looking"});
            blank3.setAnswerIndex(2);

            BlankLevel blank4 = new BlankLevel();
            blank4.setQuestion("The students are paying *** to their teacher");
            blank4.setTranslatedQuestion("Murid-murid sedang memperhatikan gurunya");
            blank4.setHand("gif/murid_lihat_guru.gif");
            blank4.setAnswers(new String[]{"attention","study","thinking","learn","borrow"});
            blank4.setAnswerIndex(0);

            LipLevel lip3 = new LipLevel();
            lip3.setQuestion("What is the pronounciation about?");
            lip3.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip3.setLip("gif/pay_attention.gif");
            lip3.setAnswers(new String[]{"Pay learn","Pay study","Pay attention","Pay thinking"});
            lip3.setAnswerIndex(2);

            LipLevel lip4 = new LipLevel();
            lip4.setQuestion("What is the pronounciation about?");
            lip4.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip4.setLip("gif/student.gif");
            lip4.setAnswers(new String[]{"Student","Teacher","Doctor","Chef"});
            lip4.setAnswerIndex(0);

            LipLevel lip5 = new LipLevel();
            lip5.setQuestion("What is the pronounciation about?");
            lip5.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip5.setLip("gif/teacher.gif");
            lip5.setAnswers(new String[]{"Doctor","Student","Chef","Teacher"});
            lip5.setAnswerIndex(3);

            MultipleLevel multiple3 = new MultipleLevel();
            multiple3.setQuestion("Which of these is 'study'?");
            multiple3.setTranslatedQuestion("Mana di bawah ini yang merupakan 'belajar'?");
            multiple3.setAnswers(new String[]{"drawable/eating","drawable/watching","drawable/study","drawable/basketball"});
            multiple3.setAnswerIndex(2);

            BasicLevel basic8 = new BasicLevel();
            basic8.setWord("Study");
            basic8.setTranslation("Belajar");
            basic8.setType("(verb) kata kerja");
            basic8.setHand("gif/belajar.gif");
            basic8.setLip("gif/study.gif");

            BasicLevel basic9 = new BasicLevel();
            basic9.setWord("I studied History yesterday");
            basic9.setTranslation("Saya belajar Sejarah kemarin");
            basic9.setType("");
            basic9.setHand("gif/saya_belajar_sejarah.gif");
            basic9.setLip("gif/i_study_history.gif");

            BlankLevel blank5 = new BlankLevel();
            blank5.setQuestion("I *** History yesterday");
            blank5.setTranslatedQuestion("Saya belajar Sejarah kemarin");
            blank5.setHand("gif/saya_belajar_sejarah.gif");
            blank5.setAnswers(new String[]{"studied","read","watched","borrowed","heard"});
            blank5.setAnswerIndex(0);

            BasicLevel basic10 = new BasicLevel();
            basic10.setWord("The students will study Math tomorrow");
            basic10.setTranslation("Murid-murid akan belajar Matematika besok");
            basic10.setType("");
            basic10.setHand("gif/murid_akan_belajar.gif");
            basic10.setLip("gif/student_will_study.gif");

            BlankLevel blank6 = new BlankLevel();
            blank6.setQuestion("The students *** *** Math tomorrow");
            blank6.setTranslatedQuestion("Murid-murid akan belajar Matematika besok");
            blank6.setHand("gif/murid_akan_belajar.gif");
            blank6.setAnswers(new String[]{"are study","is study","will study","will studied","is studied"});
            blank6.setAnswerIndex(2);

            LipLevel lip6 = new LipLevel();
            lip6.setQuestion("What is the pronounciation about?");
            lip6.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip6.setLip("gif/study.gif");
            lip6.setAnswers(new String[]{"Borrow","Learn","Read","Study"});
            lip6.setAnswerIndex(3);

            
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
            BasicLevel basic1 = new BasicLevel();
            basic1.setWord("Purchase");
            basic1.setTranslation("Beli");
            basic1.setType("(verb) kata kerja");
            basic1.setHand("gif/beli.gif");
            basic1.setLip("gif/purchase.gif");

            BasicLevel basic2 = new BasicLevel();
            basic2.setWord("Beverage");
            basic2.setTranslation("Minuman");
            basic2.setType("(noun) kata benda");
            basic2.setHand("gif/minuman.gif");
            basic2.setLip("gif/beverage.gif");

            MultipleLevel multiple1 = new MultipleLevel();
            multiple1.setQuestion("Which of these is 'purchase'?");
            multiple1.setTranslatedQuestion("Mana di bawah ini yang merupakan 'beli'?");
            multiple1.setAnswers(new String[]{"drawable/beverages","drawable/purchase","drawable/sell","drawable/grocery"});
            multiple1.setAnswerIndex(1);

            BasicLevel basic3 = new BasicLevel();
            basic3.setWord("Apparel");
            basic3.setTranslation("Pakaian");
            basic3.setType("(noun) kata benda");
            basic3.setHand("gif/pakaian.gif");
            basic3.setLip("gif/apparel.gif");

            MultipleLevel multiple2 = new MultipleLevel();
            multiple2.setQuestion("Which of these is 'beverage'?");
            multiple2.setTranslatedQuestion("Mana di bawah ini yang merupakan 'minuman'?");
            multiple2.setAnswers(new String[]{"drawable/purchase","drawable/apparel","drawable/grocery","drawable/beverages"});
            multiple2.setAnswerIndex(3);

            MultipleLevel multiple3 = new MultipleLevel();
            multiple3.setQuestion("Which of these is 'apparel'?");
            multiple3.setTranslatedQuestion("Mana di bawah ini yang merupakan 'pakaian'?");
            multiple3.setAnswers(new String[]{"drawable/sell","drawable/beverage","drawable/grocery","drawable/apparel"});
            multiple3.setAnswerIndex(3);

            DialogueLevel dialogue1 = new DialogueLevel();
            dialogue1.setDialogues(new String[]{"Ali:\n'Excuse me, where is the beverages section? I want to purchase some beverages.'",
                    "Shopkeeper:\n'It's besides the apparel section.'",
                    "Ali:\n'Thank you.'"});

            BlankLevel blank1 = new BlankLevel();
            blank1.setQuestion("Ali wants to *** some beverages.");
            blank1.setTranslatedQuestion("Ali ingin membeli beberapa minuman");
            blank1.setHand("gif/beli_beberapa_minuman.gif");
            blank1.setAnswers(new String[]{"take","sell","purchase","drink","put"});
            blank1.setAnswerIndex(2);

            LipLevel lip1 = new LipLevel();
            lip1.setQuestion("What is the pronounciation about?");
            lip1.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip1.setLip("gif/purchase.gif");
            lip1.setAnswers(new String[]{"Sell","Take","Purchase","Drink"});
            lip1.setAnswerIndex(2);

            BlankLevel blank2 = new BlankLevel();
            blank2.setQuestion("Where is the beverages question? It's *** the apparel section.");
            blank2.setTranslatedQuestion("Di mana bagian minuman? Di sebelah bagian pakaian.");
            blank2.setHand("");
            blank2.setAnswers(new String[]{"on","in","above","beside","under"});
            blank2.setAnswerIndex(3);

            LipLevel lip2 = new LipLevel();
            lip2.setQuestion("What is the pronounciation about?");
            lip2.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip2.setLip("gif/apparel.gif");
            lip2.setAnswers(new String[]{"Apparel","Beverage","Purchase","Take"});
            lip2.setAnswerIndex(0);

            LipLevel lip3 = new LipLevel();
            lip3.setQuestion("What is the pronounciation about?");
            lip3.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip3.setLip("gif/beverage.gif");
            lip3.setAnswers(new String[]{"Sell","Purchase","Apparel","Beverage"});
            lip3.setAnswerIndex(3);

            BasicLevel basic4 = new BasicLevel();
            basic4.setWord("Extravagant");
            basic4.setTranslation("Mahal");
            basic4.setType("(adjective) kata sifat");
            basic4.setHand("gif/mahal.gif");
            basic4.setLip("gif/extravagant.gif");

            BasicLevel basic5 = new BasicLevel();
            basic5.setWord("Bargain");
            basic5.setTranslation("Tawar");
            basic5.setType("(verb) kata kerja");
            basic5.setHand("gif/tawar.gif");
            basic5.setLip("gif/bargain.gif");

            MultipleTextLevel multipletext1 = new MultipleTextLevel();
            multipletext1.setWord("Mahal");
            multipletext1.setType("(adjective) kata sifat");
            multipletext1.setHand("gif/mahal.gif");
            multipletext1.setAnswers(new String[]{"Beverage","Bargain","Extravagant","Apparel"});
            multipletext1.setAnswerIndex(2);

            LipLevel lip4 = new LipLevel();
            lip4.setQuestion("What is the pronounciation about?");
            lip4.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip4.setLip("gif/bargain.gif");
            lip4.setAnswers(new String[]{"Beverage","Apparel","Purchase","Bargain"});
            lip4.setAnswerIndex(3);

            BasicLevel basic6 = new BasicLevel();
            basic6.setWord("Necessary");
            basic6.setTranslation("Perlu");
            basic6.setType("(adjective) kata sifat");
            basic6.setHand("gif/perlu.gif");
            basic6.setLip("gif/necessary.gif");

            TextLevel text1 = new TextLevel();
            text1.setText("The dress is very extravagant. So Sonya is bargaining for cheaper price. Unless, it's not necessary for her to buy it.");

            MultipleTextLevel multipletext2 = new MultipleTextLevel();
            multipletext2.setWord("Extravagant");
            multipletext2.setType("(adjective) kata sifat");
            multipletext2.setHand("gif/mahal.gif");
            multipletext2.setAnswers(new String[]{"Rich","Cheap","Necessary","Expensive"});
            multipletext2.setAnswerIndex(1);

            MultipleTextLevel multipletext3 = new MultipleTextLevel();
            multipletext3.setWord("Perlu");
            multipletext3.setType("(adjective) kata sifat");
            multipletext3.setHand("gif/perlu.gif");
            multipletext3.setAnswers(new String[]{"Necessary","Extravagant","Bargain","Purchase"});
            multipletext3.setAnswerIndex(0);

            BlankLevel blank3 = new BlankLevel();
            blank3.setQuestion("I *** for some vegetables yesterday");
            blank3.setTranslatedQuestion("Saya menawar beberapa sayuran kemarin");
            blank3.setHand("");
            blank3.setAnswers(new String[]{"bargain","sold","bargained","bargaining","ate"});
            blank3.setAnswerIndex(2);

            LipLevel lip5 = new LipLevel();
            lip5.setQuestion("What is the pronounciation about?");
            lip5.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip5.setLip("gif/extravagant.gif");
            lip5.setAnswers(new String[]{"Bargain","Necessary","Purchase","Extravagant"});
            lip5.setAnswerIndex(3);

            LipLevel lip6 = new LipLevel();
            lip6.setQuestion("What is the pronounciation about?");
            lip6.setTranslatedQuestion("Apa kata yang diucapkan?");
            lip6.setLip("gif/necessary.gif");
            lip6.setAnswers(new String[]{"Necessary","Extravagant","Bargain","Purchase"});
            lip6.setAnswerIndex(2);

            LevelFragment frag0 = BasicFragment.newInstance(basic1);
            levels.add(frag0);
            LevelFragment frag1 = BasicFragment.newInstance(basic2);
            levels.add(frag1);
            LevelFragment frag2 = MultipleFragment.newInstance(multiple1);
            levels.add(frag2);
            LevelFragment frag3 = BasicFragment.newInstance(basic3);
            levels.add(frag3);
            LevelFragment frag4 = MultipleFragment.newInstance(multiple2);
            levels.add(frag4);
            LevelFragment frag5 = MultipleFragment.newInstance(multiple3);
            levels.add(frag5);
            LevelFragment frag6 = DialogueFragment.newInstance(dialogue1);
            levels.add(frag6);
            LevelFragment frag7 = BlankFragment.newInstance(blank1);
            levels.add(frag7);
            LevelFragment frag8 = LipFragment.newInstance(lip1);
            levels.add(frag8);
            LevelFragment frag9 = BlankFragment.newInstance(blank2);
            levels.add(frag9);
            LevelFragment frag10 = LipFragment.newInstance(lip2);
            levels.add(frag10);
            LevelFragment frag11 = LipFragment.newInstance(lip3);
            levels.add(frag11);
            LevelFragment frag12 = BasicFragment.newInstance(basic4);
            levels.add(frag12);
            LevelFragment frag13 = BasicFragment.newInstance(basic5);
            levels.add(frag13);
            LevelFragment frag14 = MultipleTextFragment.newInstance(multipletext1);
            levels.add(frag14);
            LevelFragment frag15 = LipFragment.newInstance(lip4);
            levels.add(frag15);
            LevelFragment frag16 = BasicFragment.newInstance(basic6);
            levels.add(frag16);
            LevelFragment frag17 = TextFragment.newInstance(text1);
            levels.add(frag17);
            LevelFragment frag18 = MultipleTextFragment.newInstance(multipletext2);
            levels.add(frag18);
            LevelFragment frag19 = MultipleTextFragment.newInstance(multipletext3);
            levels.add(frag19);
            LevelFragment frag20 = BlankFragment.newInstance(blank3);
            levels.add(frag20);
            LevelFragment frag21 = LipFragment.newInstance(lip5);
            levels.add(frag21);
            LevelFragment frag22 = LipFragment.newInstance(lip6);
            levels.add(frag22);
        }

    }

    public ArrayList<LevelFragment> getLevels(){
        return levels;
    }
}
