package kaitor.id.talkingenglish;

import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import kaitor.id.talkingenglish.main.Dictionary;
import pl.droidsonroids.gif.GifDrawable;

public class DictionaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        final Dictionary dict = (Dictionary) getIntent().getExtras().getParcelable("Dictionary");
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }

        TextView tvWord = (TextView) findViewById(R.id.tv_word);
        TextView tvTranslation = (TextView) findViewById(R.id.tv_translation);
        TextView tvType = (TextView) findViewById(R.id.tv_type);
        ImageView imageSign = (ImageView) findViewById(R.id.image_sign);

        imageSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View alert = View.inflate(getBaseContext(),R.layout.sign_layout,null);
                ImageView gifSign = (ImageView) alert.findViewById(R.id.gif_sign);

                try {
                    GifDrawable gifFromAssets = new GifDrawable(getBaseContext().getAssets(), dict.getHand());
                    gifSign.setImageDrawable(gifFromAssets);
                } catch (IOException e) {
                    Log.d("GIF","Gagal");
                    e.printStackTrace();
                }

                AlertDialog dialog = new AlertDialog.Builder(getBaseContext())
                        .setView(alert)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
            }
        });

        tvWord.setText(dict.getWord());
        tvTranslation.setText(dict.getTranslation());
        tvType.setText(dict.getType());

    }
}
