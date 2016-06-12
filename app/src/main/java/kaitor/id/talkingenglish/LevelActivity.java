package kaitor.id.talkingenglish;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kaitor.id.talkingenglish.level.fragment.BasicFragment;
import kaitor.id.talkingenglish.level.fragment.BlankFragment;
import kaitor.id.talkingenglish.level.fragment.DialogueFragment;
import kaitor.id.talkingenglish.level.fragment.LevelFragment;
import kaitor.id.talkingenglish.level.fragment.LipFragment;
import kaitor.id.talkingenglish.level.fragment.MultipleFragment;
import kaitor.id.talkingenglish.level.fragment.MultipleLipFragment;
import kaitor.id.talkingenglish.level.fragment.MultipleTextFragment;
import kaitor.id.talkingenglish.level.fragment.TextFragment;
import kaitor.id.talkingenglish.level.fragment.TypingFragment;
import kaitor.id.talkingenglish.util.ProfileUtil;
import kaitor.id.talkingenglish.util.ProgressUtil;

public class LevelActivity extends FragmentActivity {
    FragmentManager fragmentManager;
    ArrayList<LevelFragment> levels = new ArrayList<>();
    ProgressBar progressBar;
    TextView tvScore;
    TextView tvTitle;
    private Button buttonNext;
    int currentLevel, maxLevel;
    String topic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        //TODO Initialize Level Fragments
        topic = getIntent().getExtras().getString("topic", "home");
        initLevels();

        currentLevel = 0;
        maxLevel = levels.size();

        // Initialize Component
        tvTitle = (TextView) findViewById(R.id.toolbar_title);
        tvTitle.setText("Level-" + (currentLevel + 1));
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        tvScore = (TextView) findViewById(R.id.tv_score);
        progressBar.setProgress(1);
        progressBar.setMax(maxLevel);
        tvScore.setText("" + 0);
        buttonNext = (Button) findViewById(R.id.button_next);
        TextView tvExit = (TextView) findViewById(R.id.tv_exit);
        tvExit.setTextColor(Color.BLACK);
        tvExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });


        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content, levels.get(0)).commit();
    }

    public void disableButton() {
        buttonNext.setEnabled(false);
    }

    public void enableButton() {
        buttonNext.setEnabled(true);
    }

    public void addScore(int score) {
        int currentScore = Integer.valueOf(tvScore.getText().toString());
        currentScore += score;
        tvScore.setText(currentScore + "");

        //TODO : add to profile or score util
    }

    public void initLevels() {
        //TODO : to-be-defined, take from JSON, init using Fragment class

        LevelFragment frag0 = new BasicFragment();
        levels.add(frag0);
        LevelFragment frag = new MultipleFragment();
        levels.add(frag);
        LevelFragment frag1 = new BlankFragment();
        levels.add(frag1);
        LevelFragment frag2 = new TypingFragment();
        levels.add(frag2);
        LevelFragment frag3 = new LipFragment();
        levels.add(frag3);
        LevelFragment frag4 = new MultipleLipFragment();
        levels.add(frag4);
        LevelFragment frag5 = new DialogueFragment();
        levels.add(frag5);
        LevelFragment frag6 = new TextFragment();
        levels.add(frag6);
        LevelFragment frag7 = new MultipleTextFragment();
        levels.add(frag7);
    }

    public void setButtonText(String text) {
        buttonNext.setText(text);
    }

    public Button getButtonNext() {
        return buttonNext;
    }

    public void changeLevel() {
        currentLevel++;
        progressBar.setProgress(currentLevel + 1);
        tvTitle.setText("Level-" + (currentLevel + 1));
        if (currentLevel != maxLevel) {
            Fragment fragment = levels.get(currentLevel);
            fragmentManager.beginTransaction().replace(R.id.main_content, fragment).commit();
        } else {
            ProfileUtil util = new ProfileUtil(getBaseContext());
            int currentScore = Integer.valueOf(tvScore.getText().toString());

            util.setScore(util.getScore() + currentScore);
            ProgressUtil progressUtil = new ProgressUtil(getBaseContext());
            if(progressUtil.getTopicStatus(topic)){
                Toast.makeText(getBaseContext(),"Great!\nCheckout your new score in Profile",Toast.LENGTH_SHORT).show();
            }
            else{
                progressUtil.setTopic(topic);
                Intent intent = new Intent(this,FinishActivity.class);
                intent.putExtra("score",currentScore);
                intent.putExtra("topic",topic);
                startActivity(intent);
                finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        AlertDialog dialog = new AlertDialog.Builder(getBaseContext())
                .setTitle("Confirmation")
                .setMessage("Are you sure to quit? Your current progress on this topic will be discarded.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        LevelActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick (DialogInterface dialog,int which){
                        dialog.dismiss();
                    }
                })
                .create();
    }
}
