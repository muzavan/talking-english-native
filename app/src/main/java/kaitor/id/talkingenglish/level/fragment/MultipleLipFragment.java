package kaitor.id.talkingenglish.level.fragment;

import android.os.Build;
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
import kaitor.id.talkingenglish.level.model.MultipleLipLevel;

/**
 * Created by user pc on 6/12/2016.
 */
public class MultipleLipFragment extends LevelFragment{
    private final int BORDER = R.drawable.background_border_orange;
    private int selectedAnswer;
    private MultipleLipLevel actualLevel;
    private boolean helpShown = false;
    ImageView imageAnswer0;
    ImageView imageAnswer1;
    ImageView imageAnswer2;
    ImageView imageAnswer3;

    public MultipleLipFragment() {
        // TODO : Define here
        dummyData();
    }

    public void dummyData() {
        actualLevel = new MultipleLipLevel();
        actualLevel.setAnswerIndex(2);
        actualLevel.setImageQuestion("drawable/daughter_avatar");
        actualLevel.setImageAnswers(new String[]{"drawable/daughter_avatar", "drawable/mother_avatar", "drawable/father_avatar", "drawable/son_avatar"});
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_multiple_lip, container, false);
        ImageView imageQuestion = (ImageView) view.findViewById(R.id.image_question);
        final TextView tvTranslation = (TextView) view.findViewById(R.id.tv_translation);
        TextView tvHelp = (TextView) view.findViewById(R.id.tv_help_text);
        imageAnswer1 = (ImageView) view.findViewById(R.id.image_answer_1);
        imageAnswer2 = (ImageView) view.findViewById(R.id.image_answer_2);
        imageAnswer3 = (ImageView) view.findViewById(R.id.image_answer_3);
        imageAnswer0 = (ImageView) view.findViewById(R.id.image_answer_0);

        imageQuestion.setImageResource(getResources().getIdentifier(actualLevel.getImageQuestion(), null, getActivity().getPackageName()));
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
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageAnswer1.setBackground(getResources().getDrawable(BORDER,null));
                }
                else{
                    imageAnswer1.setBackground(getResources().getDrawable(BORDER));
                }
                selectedAnswer=1;
            }
        });

        imageAnswer2.setImageResource(resources[2]);
        imageAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAnswer();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageAnswer2.setBackground(getResources().getDrawable(BORDER,null));
                }
                else{
                    imageAnswer2.setBackground(getResources().getDrawable(BORDER));
                }
                selectedAnswer=2;
            }
        });

        imageAnswer3.setImageResource(resources[3]);
        imageAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAnswer();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageAnswer3.setBackground(getResources().getDrawable(BORDER,null));
                }
                else{
                    imageAnswer3.setBackground(getResources().getDrawable(BORDER));
                }
                selectedAnswer=3;
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imageAnswer0.setBackground(getResources().getDrawable(BORDER,null));
        }
        else{
            imageAnswer0.setBackground(getResources().getDrawable(BORDER));
        }

        imageAnswer0.setImageResource(resources[0]);
        imageAnswer0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAnswer();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    imageAnswer0.setBackground(getResources().getDrawable(BORDER,null));
                }
                else{
                    imageAnswer0.setBackground(getResources().getDrawable(BORDER));
                }
                selectedAnswer=0;
            }
        });


        setNextButton();


        return view;
    }

    public int[] convertAnswerToResource() {
        int[] resources = new int[actualLevel.getImageAnswers().length];

        for (int i = 0; i < resources.length; i++) {
            String uri = actualLevel.getImageAnswers()[i];
            resources[i] = getResources().getIdentifier(uri, null, getActivity().getPackageName());
        }

        return resources;
    }

    public void initAnswer() {
        imageAnswer1.setBackground(null);
        imageAnswer2.setBackground(null);
        imageAnswer3.setBackground(null);
        imageAnswer0.setBackground(null);
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
