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

import kaitor.id.talkingenglish.level.fragment.BlankFragment;
import kaitor.id.talkingenglish.level.fragment.LevelFragment;
import kaitor.id.talkingenglish.level.fragment.MultipleFragment;

public class LevelActivity extends FragmentActivity {
    FragmentManager fragmentManager;
    ArrayList<LevelFragment> levels = new ArrayList<>();
    ProgressBar progressBar;
    TextView tvScore;
    private Button buttonNext;
    int currentLevel, maxLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        //TODO Initialize Level Fragments
        initLevels();

        currentLevel = 0;
        maxLevel = levels.size();

        // Initialize Component
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        tvScore = (TextView) findViewById(R.id.tv_score);
        progressBar.setProgress(1);
        progressBar.setMax(maxLevel);
        tvScore.setText(""+0);
        buttonNext = (Button) findViewById(R.id.button_next);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content,levels.get(0)).commit();
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
        LevelFragment frag1 = new BlankFragment();
        levels.add(frag1);
    }

    public void setButtonText(String text){
        buttonNext.setText(text);
    }

    public Button getButtonNext(){
        return buttonNext;
    }

    public void changeLevel(){
        currentLevel++;
        progressBar.setProgress(currentLevel+1);
        if(currentLevel!=maxLevel){
            Fragment fragment = levels.get(currentLevel);
            fragmentManager.beginTransaction().replace(R.id.main_content,fragment).commit();
        }
        else{
            finish();
        }
    }


}
