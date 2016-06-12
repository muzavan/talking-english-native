package kaitor.id.talkingenglish;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int level = getIntent().getExtras().getInt("level",0);
        switch (level){
            case 1 :
                setContentView(R.layout.activity_choose_intermediate);
                break;
            case 2 :
                setContentView(R.layout.activity_choose_advanced);
                break;
            default:
                setContentView(R.layout.activity_choose);
                break;
        }


        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        toolbarTitle.setText("Choose Topic");
        ImageView imgView = (ImageView) findViewById(R.id.image_level_1);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseActivity.this,LevelActivity.class);
                /**
                 * TODO : Put Topic and Level
                 */
                switch (level){
                    case 1 :
                        intent.putExtra("topic","school");
                        break;
                    case 2 :
                        intent.putExtra("topic","supermarket");
                        break;
                    default:
                        intent.putExtra("topic","home");
                        break;
                }
                startActivity(intent);
            }
        });

        ImageView imgView2 = (ImageView) findViewById(R.id.image_level_2);
        ImageView imgView3 = (ImageView) findViewById(R.id.image_level_3);
        ImageView imgView4 = (ImageView) findViewById(R.id.image_level_4);

        imgView2.setOnClickListener(this);
        imgView3.setOnClickListener(this);
        imgView4.setOnClickListener(this);

        TextView tvChoose = (TextView) findViewById(R.id.tv_choose);
        Typeface typef = Typeface.createFromAsset(getAssets(),"font/Moon Flower Bold.ttf");
        tvChoose.setTypeface(typef);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getBaseContext(),"Coming Soon :-) ",Toast.LENGTH_SHORT).show();
    }
}
