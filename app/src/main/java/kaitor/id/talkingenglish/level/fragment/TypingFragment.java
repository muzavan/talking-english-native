package kaitor.id.talkingenglish.level.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kaitor.id.talkingenglish.LevelActivity;
import kaitor.id.talkingenglish.R;
import kaitor.id.talkingenglish.level.model.TypingLevel;

/**
 * Created by user pc on 5/30/2016.
 */
public class TypingFragment extends LevelFragment {
    private TypingLevel actualLevel;
    private boolean hintShown = false;
    private EditText editAnswer;

    public TypingFragment(){
        dummyData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_level_typing,container,false);
        TextView tvQuestion = (TextView) view.findViewById(R.id.tv_question);
        TextView tvTranslation = (TextView) view.findViewById(R.id.tv_translation);
        final TextView tvInstruction = (TextView) view.findViewById(R.id.tv_instruction_hint);
        TextView tvHelp = (TextView) view.findViewById(R.id.tv_help_text);
        editAnswer = (EditText) view.findViewById(R.id.edit_answer);

        tvQuestion.setText(actualLevel.getQuestion());
        tvTranslation.setText(actualLevel.getTranslatedQuestion());
        tvInstruction.setVisibility(View.GONE);

        tvHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hintShown = !hintShown;
                if(hintShown){
                    tvInstruction.setVisibility(View.VISIBLE);
                }
                else{
                    tvInstruction.setVisibility(View.GONE);
                }
            }
        });

        setNextButton();

        return view;
    }



    public void dummyData(){
        actualLevel = new TypingLevel();
        actualLevel.setAnswer("Mother");
        actualLevel.setQuestion("She is a ___");
        actualLevel.setTranslatedQuestion("Dia adalah seorang ibu");
    }

    public void setNextButton(){
        final LevelActivity activity = (LevelActivity) getActivity();
        Button buttonNext = activity.getButtonNext();

        buttonNext.setText("CHECK");
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editAnswer.getText().toString() == ""){
                    Toast.makeText(getContext(),"Please input your answer",Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    if(editAnswer.getText().toString().equalsIgnoreCase(actualLevel.getAnswer())){
                        Toast.makeText(getContext(),"You're right!",Toast.LENGTH_SHORT).show();
                        activity.addScore(20);
                    }
                    else{
                        Toast.makeText(getContext(),"You're wrong.",Toast.LENGTH_SHORT).show();
                    }
                    activity.changeLevel();
                }
            }
        });
    }
}
