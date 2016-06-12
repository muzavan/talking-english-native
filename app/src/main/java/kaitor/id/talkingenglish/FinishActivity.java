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

        //Beginner
        if(topic.equalsIgnoreCase("home")){
            imageBadge.setImageResource(R.drawable.home_badge);
        }
        if(topic.equalsIgnoreCase("fruits")){
            imageBadge.setImageResource(R.drawable.fruits_badge);
        }
        if(topic.equalsIgnoreCase("number")){
            imageBadge.setImageResource(R.drawable.number_badge);
        }
        if(topic.equalsIgnoreCase("family")){
            imageBadge.setImageResource(R.drawable.family_badge);
        }

        //Intermediate
        if(topic.equalsIgnoreCase("school")){
            imageBadge.setImageResource(R.drawable.school_badge);
        }
        if(topic.equalsIgnoreCase("transportation")){
            imageBadge.setImageResource(R.drawable.transportation_badge);
        }
        if(topic.equalsIgnoreCase("library")){
            imageBadge.setImageResource(R.drawable.library_badge);
        }
        if(topic.equalsIgnoreCase("hobbies")){
            imageBadge.setImageResource(R.drawable.hobbies_badge);
        }

        //Advanced
        if(topic.equalsIgnoreCase("supermarket")){
            imageBadge.setImageResource(R.drawable.supermarket_badge);
        }
        if(topic.equalsIgnoreCase("factory")){
            imageBadge.setImageResource(R.drawable.factory_badge);
        }
        if(topic.equalsIgnoreCase("traffic")){
            imageBadge.setImageResource(R.drawable.traffic_badge);
        }
        if(topic.equalsIgnoreCase("hospital")){
            imageBadge.setImageResource(R.drawable.hospital_badge);
        }
        
        tvScore.setText(""+score);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}