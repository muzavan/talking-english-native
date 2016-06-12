package kaitor.id.talkingenglish.training;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import kaitor.id.talkingenglish.LevelActivity;
import kaitor.id.talkingenglish.R;

/**
 * Created by user pc on 6/12/2016.
 */
public class TrainingUnderstandFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_training_badge,container,false);
        Button buttonOk = (Button) view.findViewById(R.id.button_ok);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LevelActivity.class);
                intent.putExtra("topic",getArguments().getString("topic"));
                startActivity(intent);
                getActivity().finish();
            }
        });

        return view;
    }

    public static TrainingUnderstandFragment newInstance(String topic) {

        Bundle args = new Bundle();
        args.putString("topic",topic);
        TrainingUnderstandFragment fragment = new TrainingUnderstandFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
