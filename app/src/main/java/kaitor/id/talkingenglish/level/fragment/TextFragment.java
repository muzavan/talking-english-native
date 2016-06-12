package kaitor.id.talkingenglish.level.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import kaitor.id.talkingenglish.LevelActivity;
import kaitor.id.talkingenglish.R;
import kaitor.id.talkingenglish.level.model.TextLevel;

/**
 * Created by user pc on 6/12/2016.
 */
public class TextFragment extends LevelFragment {
    private TextLevel actualLevel;
    private boolean helpShown = false;

    public TextFragment(){
        super();
        initDummy();
    }

    public void initDummy(){
        actualLevel = new TextLevel();
        actualLevel.setText("This is an example of a text that will be used as a comprehensive text.");
    }

    public static TextFragment newInstance(TextLevel level) {

        Bundle args = new Bundle();

        TextFragment fragment = new TextFragment();
        fragment.setArguments(args);
        fragment.setLevel(level);
        return fragment;
    }

    public void setLevel(TextLevel level){
        actualLevel = level;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_text,container,false);
        final TextView tvTranslation = (TextView) view.findViewById(R.id.tv_translation);
        TextView tvHelp = (TextView) view.findViewById(R.id.tv_help_text);
        tvTranslation.setVisibility(View.GONE);

        tvHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helpShown = !helpShown;
                if (helpShown) {
                    tvTranslation.setVisibility(View.VISIBLE);
                } else {
                    tvTranslation.setVisibility(View.GONE);
                }
            }
        });

        setNextButton();

        TextView tvText = (TextView) view.findViewById(R.id.tv_text);
        tvText.setText(actualLevel.getText());
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
