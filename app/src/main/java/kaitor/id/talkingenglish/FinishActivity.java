package kaitor.id.talkingenglish;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import kaitor.id.talkingenglish.level.model.TextLevel;

/**
 * Created by user pc on 6/12/2016.
 */
public class FinishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        int score = getIntent().getExtras().getInt("score",0);
        String topic = getIntent().getExtras().getString("topic","home");

        TextView tvScore = (TextView) findViewById(R.id.tv_score);
        ImageView imageBadge = (ImageView) findViewById(R.id.image_badge);
        Button buttonContinue = (Button) findViewById(R.id.button_continue);

        tvScore.setText(""+score);

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}