package kaitor.id.talkingenglish;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
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

import kaitor.id.talkingenglish.level.fragment.LevelFragment;
import kaitor.id.talkingenglish.util.LevelUtil;
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
    }

    public void initLevels() {
            LevelUtil util = new LevelUtil(topic);
            levels.addAll(util.getLevels());
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
        DialogFragment newFragment = ConfirmDialogFragment.newInstance();
        newFragment.show(getSupportFragmentManager(),"title");
    }

    public static class ConfirmDialogFragment extends DialogFragment {

        public static ConfirmDialogFragment newInstance() {
            ConfirmDialogFragment frag = new ConfirmDialogFragment();
            Bundle args = new Bundle();
            frag.setArguments(args);
            return frag;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            return new AlertDialog.Builder(getContext())
                    .setTitle("Confirmation")
                    .setMessage("Are you sure to quit? Your current progress on this topic will be discarded.")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            getActivity().finish();
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
}
