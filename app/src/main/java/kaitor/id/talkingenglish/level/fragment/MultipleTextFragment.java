package kaitor.id.talkingenglish.level.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.logging.Level;

import kaitor.id.talkingenglish.LevelActivity;
import kaitor.id.talkingenglish.R;
import kaitor.id.talkingenglish.level.model.LipLevel;
import kaitor.id.talkingenglish.level.model.MultipleTextLevel;
import pl.droidsonroids.gif.GifDrawable;

/**
 * Created by user pc on 6/12/2016.
 */
public class MultipleTextFragment extends LevelFragment {
   private final float ALPHA = 0.6f;
    private int selectedAnswer;
    private MultipleTextLevel actualLevel;
    private boolean helpShown = false;
    TextView tvAnswer1;
    TextView tvAnswer2;
    TextView tvAnswer3;
    TextView tvAnswer0;

    public MultipleTextFragment() {
        // TODO : Define here
        dummyData();
    }

    public void dummyData() {
        actualLevel = new MultipleTextLevel();
        actualLevel.setAnswerIndex(1);
        actualLevel.setWord("Extravagant");
        actualLevel.setType("(adj) kata sifat");
        actualLevel.setAnswers(new String[]{"Rich","Cheap","Necessary","Expensive"});
        actualLevel.setHand("gif/example.gif");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_multiple_text, container, false);
        TextView tvWord = (TextView) view.findViewById(R.id.tv_word);
        TextView tvType = (TextView) view.findViewById(R.id.tv_type);
        final TextView tvTranslation = (TextView) view.findViewById(R.id.tv_translation);
        TextView tvHelp = (TextView) view.findViewById(R.id.tv_help_text);
        tvAnswer1 = (TextView) view.findViewById(R.id.tv_answer_1);
        tvAnswer2 = (TextView) view.findViewById(R.id.tv_answer_2);
        tvAnswer3 = (TextView) view.findViewById(R.id.tv_answer_3);
        tvAnswer0 = (TextView) view.findViewById(R.id.tv_answer_0);
        ImageView imageSign = (ImageView) view.findViewById(R.id.image_sign);
        imageSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View alert = View.inflate(getContext(),R.layout.sign_layout,null);
                ImageView gifSign = (ImageView) alert.findViewById(R.id.gif_sign);

                try {
                    GifDrawable gifFromAssets = new GifDrawable(getContext().getAssets(), actualLevel.getHand());
                    gifSign.setImageDrawable(gifFromAssets);
                } catch (IOException e) {
                    Log.d("GIF","Gagal");
                    e.printStackTrace();
                }

                AlertDialog dialog = new AlertDialog.Builder(getContext())
                        .setView(alert)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
            }
        });

        tvWord.setText(actualLevel.getWord());
        tvType.setText(actualLevel.getType());
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

        tvAnswer1.setText(actualLevel.getAnswers()[1]);
        tvAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAnswer();
                tvAnswer1.setAlpha(1.f);
                selectedAnswer=1;
            }
        });

        tvAnswer2.setText(actualLevel.getAnswers()[2]);
        tvAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAnswer();
                tvAnswer2.setAlpha(1.f);
                selectedAnswer=2;
            }
        });

        tvAnswer3.setText(actualLevel.getAnswers()[3]);
        tvAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAnswer();
                tvAnswer3.setAlpha(1.f);
                selectedAnswer=3;
            }
        });

        tvAnswer0.setText(actualLevel.getAnswers()[0]);
        tvAnswer0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAnswer();
                tvAnswer0.setAlpha(1.f);
                selectedAnswer=0;
            }
        });


        setNextButton();
        return view;
    }


    public void initAnswer() {
        tvAnswer1.setAlpha(ALPHA);
        tvAnswer2.setAlpha(ALPHA);
        tvAnswer3.setAlpha(ALPHA);
        tvAnswer0.setAlpha(ALPHA);
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
