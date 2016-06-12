package kaitor.id.talkingenglish.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import kaitor.id.talkingenglish.ChooseActivity;
import kaitor.id.talkingenglish.R;
import kaitor.id.talkingenglish.util.LevelUtil;
import kaitor.id.talkingenglish.util.ProgressUtil;

/**
 * Created by user pc on 5/28/2016.
 */
public class LearnFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_learn, container, false);
        View layoutBeginner = view.findViewById(R.id.layout_beginner);
        ProgressBar progressBeginner = (ProgressBar) view.findViewById(R.id.progress_beginner);
        View layoutIntermediate = view.findViewById(R.id.layout_intermediate);
        ProgressBar progressIntermediate = (ProgressBar) view.findViewById(R.id.progress_intermediate);
        View layoutAdvanced = view.findViewById(R.id.layout_advanced);
        ProgressBar progressAdvanced = (ProgressBar) view.findViewById(R.id.progress_advanced);

        ProgressUtil progressUtil = new ProgressUtil(getContext());

        layoutBeginner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChooseActivity.class);
                intent.putExtra("level",0);
                getActivity().startActivity(intent);
            }
        });

        progressBeginner.setProgress(progressUtil.getBeginner());
        progressBeginner.setMax(LevelUtil.BEGINNER_LEVELS.length);

        layoutIntermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChooseActivity.class);
                intent.putExtra("level",1);
                getActivity().startActivity(intent);
            }
        });

        progressIntermediate.setProgress(progressUtil.getIntermediate());
        progressIntermediate.setMax(LevelUtil.INTERMEDIATE_LEVELS.length);

        layoutAdvanced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChooseActivity.class);
                intent.putExtra("level",2);
                getActivity().startActivity(intent);
            }
        });

        progressAdvanced.setProgress(progressUtil.getAdvanced());
        progressAdvanced.setMax(LevelUtil.ADVANCED_LEVELS.length);

        return view;
    }
}
