package kaitor.id.talkingenglish.level.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import kaitor.id.talkingenglish.LevelActivity;
import kaitor.id.talkingenglish.R;
import kaitor.id.talkingenglish.level.model.BasicLevel;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by user pc on 5/30/2016.
 */
public class BasicFragment extends LevelFragment{
    private BasicLevel actualLevel;

    public BasicFragment(){
        super();
        initDummy();
    }

    public BasicFragment(BasicLevel _actualLevel){
        super();
        actualLevel=_actualLevel;

    }

    public void initDummy(){
        actualLevel = new BasicLevel();
        actualLevel.setType("(n) kata benda");
        actualLevel.setTranslation("Ibu");
        actualLevel.setWord("Mother");
        actualLevel.setLip("gif/example.gif");
        actualLevel.setHand("gif/example.gif");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_basic,container,false);
        TextView tvWord = (TextView) view.findViewById(R.id.tv_word);
        TextView tvTranslation = (TextView) view.findViewById(R.id.tv_translation);
        TextView tvType = (TextView) view.findViewById(R.id.tv_type);
        ImageView imageLip = (ImageView) view.findViewById(R.id.image_lip);
        ImageView imageSign = (ImageView) view.findViewById(R.id.image_sign);
        try {
            GifDrawable gifFromAssets = new GifDrawable(getContext().getAssets(), actualLevel.getLip() );
            imageLip.setImageDrawable(gifFromAssets);
        } catch (IOException e) {
            Log.d("GIF","Gagal");
            e.printStackTrace();
        }

        imageSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View alert = View.inflate(getContext(),R.layout.sign_layout,null);
                ImageView gifSign = (ImageView) alert.findViewById(R.id.gif_sign);

                try {
                    GifDrawable gifFromAssets = new GifDrawable(getContext().getAssets(), actualLevel.getHand());
                    gifSign.setImageDrawable(gifFromAssets);
                } catch (IOException e) {
                    Log.d("GIF","Gagal");
                    e.printStackTrace();
                }

                AlertDialog dialog = new AlertDialog.Builder(getContext())
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

        tvWord.setText(actualLevel.getWord());
        tvTranslation.setText(actualLevel.getTranslation());
        tvType.setText(actualLevel.getType());
        //imageLip.setImageResource(getResources().getIdentifier(actualLevel.getLip(), null, getActivity().getPackageName()));
        setNextButton();
        return view;
    }

    public void setNextButton(){
        final LevelActivity activity = (LevelActivity) getActivity();
        Button btnNext = activity.getButtonNext();//(Button)activity.findViewById(R.id.button_next);

        btnNext.setText("NEXT");
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeLevel();
            }
        });
    }


}
