package kaitor.id.talkingenglish.level.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kaitor.id.talkingenglish.LevelActivity;
import kaitor.id.talkingenglish.R;
import kaitor.id.talkingenglish.level.model.BasicLevel;

/**
 * Created by user pc on 5/30/2016.
 */
public class BasicFragment extends LevelFragment{
    private BasicLevel actualLevel;

    public BasicFragment(){
        super();
        initDummy();
    }

    public void initDummy(){
        actualLevel = new BasicLevel();
        actualLevel.setType("(n) kata benda");
        actualLevel.setTranslation("Ibu");
        actualLevel.setWord("Mother");
        actualLevel.setLip("drawable/father_lipread");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_basic,container,false);
        TextView tvWord = (TextView) view.findViewById(R.id.tv_word);
        TextView tvTranslation = (TextView) view.findViewById(R.id.tv_translation);
        TextView tvType = (TextView) view.findViewById(R.id.tv_type);
        ImageView imageLip = (ImageView) view.findViewById(R.id.image_lip);

        tvWord.setText(actualLevel.getWord());
        tvTranslation.setText(actualLevel.getTranslation());
        tvType.setText(actualLevel.getType());
        imageLip.setImageResource(getResources().getIdentifier(actualLevel.getLip(), null, getActivity().getPackageName()));
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
