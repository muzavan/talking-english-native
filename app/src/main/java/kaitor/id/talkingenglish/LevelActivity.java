package kaitor.id.talkingenglish;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import kaitor.id.talkingenglish.level.fragment.LevelFragment;
import kaitor.id.talkingenglish.level.fragment.MultipleFragment;

public class LevelActivity extends FragmentActivity {
    FragmentManager fragmentManager;
    ArrayList<LevelFragment> levels = new ArrayList<>();
    ProgressBar progressBar;
    TextView tvScore;
    Button buttonNext;
    int currentLevel, maxLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        //TODO Initialize Level Fragments
        initLevels();

        currentLevel = 0;

        // Initialize Component
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        TextView tvScore = (TextView) findViewById(R.id.tv_score);
        tvScore.setText(""+0);
        Button buttonNext = (Button) findViewById(R.id.button_next);
        fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.main_content,levels.get(0)).commit();
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentLevel++;
                Fragment fragment = levels.get(currentLevel);
                fragmentManager.beginTransaction().replace(R.id.main_content,fragment).commit();
            }
        });
    }

    public void disableButton(){
        buttonNext.setEnabled(false);
    }

    public void enableButton(){
        buttonNext.setEnabled(true);
    }

    public void addScore(int score){
        int currentScore = Integer.valueOf(tvScore.getText().toString());
        currentScore+=score;
        tvScore.setText(currentScore+"");

        //TODO : add to profile or score util
    }

    public void initLevels(){
        //TODO : to-be-defined, take from JSON, init using Fragment class
        LevelFragment frag = new MultipleFragment();
        levels.add(frag);
    }

    public void setButtonText(String text){
        buttonNext.setText(text);
    }


}
