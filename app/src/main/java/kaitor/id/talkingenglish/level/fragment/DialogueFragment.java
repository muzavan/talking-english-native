package kaitor.id.talkingenglish.level.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import kaitor.id.talkingenglish.LevelActivity;
import kaitor.id.talkingenglish.R;
import kaitor.id.talkingenglish.level.adapter.DialogueAdapter;
import kaitor.id.talkingenglish.level.model.DialogueLevel;
import kaitor.id.talkingenglish.main.Dictionary;
import kaitor.id.talkingenglish.main.DictionaryAdapter;

/**
 * Created by user pc on 6/12/2016.
 */
public class DialogueFragment extends LevelFragment {
    private DialogueLevel actualLevel;
    private boolean helpShown = false;

    public DialogueFragment(){
        super();
        initDummy();
    }

    public void initDummy(){
        actualLevel = new DialogueLevel();
        actualLevel.setDialogues(new String[]{"Joshua:\nHello Kaito!","Kaito:\nHello Joshua!"});
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_dialogue,container,false);

        //Prepare List Adapter
        ListView listDialogue = (ListView) view.findViewById(R.id.list_dialogue);
        DialogueAdapter adapter = new DialogueAdapter(getContext(),R.layout.item_dialogue,actualLevel.getDialogues());
        listDialogue.setAdapter(adapter);

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
        ((LevelActivity)getActivity()).setButtonText("NEXT");
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
