package kaitor.id.talkingenglish.level.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kaitor.id.talkingenglish.LevelActivity;
import kaitor.id.talkingenglish.R;
import kaitor.id.talkingenglish.level.model.MultipleLevel;

/**
 * Created by user pc on 5/30/2016.
 */
public class MultipleFragment extends LevelFragment {
    private final float ALPHA = 0.4f;
    private int selectedAnswer;
    private MultipleLevel actualLevel;
    private boolean helpShown = false;
    ImageView imageAnswer1;
    ImageView imageAnswer2;
    ImageView imageAnswer3;
    ImageView imageAnswer0;

    public MultipleFragment() {
        // TODO : Define here
        dummyData();
    }

    public void dummyData() {
        actualLevel = new MultipleLevel();
        actualLevel.setAnswerIndex(2);
        actualLevel.setQuestion("Which of these is 'The Father'?");
        actualLevel.setTranslatedQuestion("Mana yang merupakan 'Ayah'?");
        actualLevel.setAnswers(new String[]{"drawable/daughter_avatar", "drawable/mother_avatar", "drawable/father_avatar", "drawable/son_avatar"});
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_multiple, container, false);
        TextView tvQuestion = (TextView) view.findViewById(R.id.tv_question);
        final TextView tvTranslation = (TextView) view.findViewById(R.id.tv_translation);
        TextView tvHelp = (TextView) view.findViewById(R.id.tv_help_text);
        imageAnswer1 = (ImageView) view.findViewById(R.id.image_answer_1);
        imageAnswer2 = (ImageView) view.findViewById(R.id.image_answer_2);
        imageAnswer3 = (ImageView) view.findViewById(R.id.image_answer_3);
        imageAnswer0 = (ImageView) view.findViewById(R.id.image_answer_0);

        tvQuestion.setText(actualLevel.getQuestion());
        tvTranslation.setText(actualLevel.getTranslatedQuestion());
        tvTranslation.setVisibility(View.GONE);

        tvHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpShown = !helpShown;
                if (helpShown) {
                    tvTranslation.setVisibility(View.VISIBLE);
                } else {
                    tvTranslation.setVisibility(View.GONE);
                }
            }
        });

        int[] resources = convertAnswerToResource();
        imageAnswer1.setImageResource(resources[1]);
        imageAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAnswer();
                imageAnswer1.setAlpha(1.f);
                selectedAnswer=1;
            }
        });

        imageAnswer2.setImageResource(resources[2]);
        imageAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAnswer();
                imageAnswer2.setAlpha(1.f);
                selectedAnswer=2;
            }
        });

        imageAnswer3.setImageResource(resources[3]);
        imageAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAnswer();
                imageAnswer3.setAlpha(1.f);
                selectedAnswer=3;
            }
        });

        imageAnswer0.setImageResource(resources[0]);
        imageAnswer0.setAlpha(1.0f);
        imageAnswer0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAnswer();
                imageAnswer0.setAlpha(1.f);
                selectedAnswer=0;
            }
        });


        setNextButton();


        return view;
    }

    public int[] convertAnswerToResource() {
        int[] resources = new int[actualLevel.getAnswers().length];

        for (int i = 0; i < resources.length; i++) {
            String uri = actualLevel.getAnswers()[i];
            resources[i] = getResources().getIdentifier(uri, null, getActivity().getPackageName());
        }

        return resources;
    }

    public void initAnswer() {
        imageAnswer1.setAlpha(ALPHA);
        imageAnswer2.setAlpha(ALPHA);
        imageAnswer3.setAlpha(ALPHA);
        imageAnswer0.setAlpha(ALPHA);
    }

    public void setNextButton(){
        final LevelActivity activity = (LevelActivity) getActivity();
        Button btnNext = activity.getButtonNext();//(Button)activity.findViewById(R.id.button_next);

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
