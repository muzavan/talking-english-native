package kaitor.id.talkingenglish;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import kaitor.id.talkingenglish.level.fragment.LevelFragment;

public class LevelActivity extends FragmentActivity {
    FragmentManager fragmentManager;
    ArrayList<LevelFragment> levels;
    ProgressBar progressBar;
    TextView tvScore;
    Button nextButton;
    int currentLevel, maxLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        // Initialize Component
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        

        fragmentManager = getSupportFragmentManager();
    }
}
