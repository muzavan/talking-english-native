package kaitor.id.talkingenglish;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ChooseActivity extends AppCompatActivity {

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
    }
}
