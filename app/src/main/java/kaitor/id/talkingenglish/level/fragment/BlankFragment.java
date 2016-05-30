package kaitor.id.talkingenglish.level.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import kaitor.id.talkingenglish.LevelActivity;
import kaitor.id.talkingenglish.R;
import kaitor.id.talkingenglish.level.model.BlankLevel;

/**
 * Created by user pc on 5/30/2016.
 */
public class BlankFragment extends LevelFragment {
    private BlankLevel actualLevel;
    private int selectedAnswer;
    TextView tvAnswer0,tvAnswer1,tvAnswer2,tvAnswer3,tvAnswer4;
    private boolean hintShown = false;

    public BlankFragment(){

        dummyData();
    }

    public void dummyData(){
        actualLevel = new BlankLevel();
        actualLevel.setQuestion("He *** a father"); // *** will be intepreted as blank
        actualLevel.setTranslatedQuestion("Dia adalah seorang ayah");
        actualLevel.setAnswers(new String[]{"am","are","is","she","it"});
        actualLevel.setAnswerIndex(2);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_blank,container,false);
        final TextView tvQuestion = (TextView) view.findViewById(R.id.tv_question);
        TextView tvTranslation = (TextView) view.findViewById(R.id.tv_translation);
        TextView tvHelp = (TextView) view.findViewById(R.id.tv_help_text);
        final TextView tvInstuctionHint = (TextView) view.findViewById(R.id.tv_instruction_hint);

        tvAnswer0 = (TextView) view.findViewById(R.id.tv_answer_0);
        tvAnswer1 = (TextView) view.findViewById(R.id.tv_answer_1);
        tvAnswer2 = (TextView) view.findViewById(R.id.tv_answer_2);
        tvAnswer3 = (TextView) view.findViewById(R.id.tv_answer_3);
        tvAnswer4 = (TextView) view.findViewById(R.id.tv_answer_4);

        tvQuestion.setText(actualLevel.getQuestion().replace("***","___"));
        tvTranslation.setText(actualLevel.getTranslatedQuestion());
        tvHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hintShown = !hintShown;
                if(hintShown){
                    tvInstuctionHint.setVisibility(View.VISIBLE);
                }
                else{
                    tvInstuctionHint.setVisibility(View.GONE);
                }
            }
        });

        tvInstuctionHint.setVisibility(View.GONE);

        tvAnswer0.setText(actualLevel.getAnswers()[0]);
        tvAnswer0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = actualLevel.getQuestion();
                String ans = actualLevel.getAnswers()[0];
                s = s.replace("***",ans);
                tvQuestion.setText(s);
                selectedAnswer = 0;
            }
        });

        tvAnswer1.setText(actualLevel.getAnswers()[1]);
        tvAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = actualLevel.getQuestion();
                String ans = actualLevel.getAnswers()[1];
                s = s.replace("***",ans);
                tvQuestion.setText(s);
                selectedAnswer = 1;
            }
        });

        tvAnswer2.setText(actualLevel.getAnswers()[2]);
        tvAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = actualLevel.getQuestion();
                String ans = actualLevel.getAnswers()[2];
                s = s.replace("***",ans);
                tvQuestion.setText(s);
                selectedAnswer = 2;
            }
        });

        tvAnswer3.setText(actualLevel.getAnswers()[3]);
        tvAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = actualLevel.getQuestion();
                String ans = actualLevel.getAnswers()[3];
                s = s.replace("***",ans);
                tvQuestion.setText(s);
                selectedAnswer = 3;
            }
        });

        tvAnswer4.setText(actualLevel.getAnswers()[4]);
        tvAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = actualLevel.getQuestion();
                String ans = actualLevel.getAnswers()[4];
                s = s.replace("***",ans);
                tvQuestion.setText(s);
                selectedAnswer = 4;
            }
        });

        setNextButton();
        return view;
    }

    public void setNextButton(){
        final LevelActivity activity = (LevelActivity) getActivity();
        Button btnNext = activity.getButtonNext();

        btnNext.setText("CHECK");
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedAnswer == actualLevel.getAnswerIndex()){
                    activity.addScore(20);
                    Toast.makeText(getContext(),"You're right!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getContext(),"You're wrong!",Toast.LENGTH_SHORT).show();
                }
                activity.changeLevel();
            }
        });
    }
}
