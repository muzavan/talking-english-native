package kaitor.id.talkingenglish;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import kaitor.id.talkingenglish.main.Dictionary;

public class DictionaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        Dictionary dict = (Dictionary) getIntent().getExtras().getParcelable("Dictionary");
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

        TextView tvWord = (TextView) findViewById(R.id.tv_word);
        TextView tvTranslation = (TextView) findViewById(R.id.tv_translation);
        TextView tvType = (TextView) findViewById(R.id.tv_type);

        tvWord.setText(dict.getWord());
        tvTranslation.setText(dict.getTranslation());
        tvType.setText(dict.getType());

    }
}
