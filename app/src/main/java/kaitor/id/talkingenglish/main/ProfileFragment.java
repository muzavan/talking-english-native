package kaitor.id.talkingenglish.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kaitor.id.talkingenglish.R;
import kaitor.id.talkingenglish.util.ProfileUtil;

/**
 * Created by user pc on 5/28/2016.
 */
public class ProfileFragment extends Fragment {
    private TextView tvScore;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container,false);
        final EditText editName = (EditText) view.findViewById(R.id.edit_name);
        final ProfileUtil util = new ProfileUtil(getContext());
        editName.setText(util.getName());
        editName.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                editName.requestFocusFromTouch(); // to get focus from tab host
                return false;
            }
        });

        Button buttonChange = (Button) view.findViewById(R.id.button_change);
        buttonChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editName.getText().toString().equals("")){
                    util.setName(editName.getText().toString());
                    Toast.makeText(getContext(),"Name has been successfully changed!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getContext(),"Please enter your name.",Toast.LENGTH_SHORT).show();
                    editName.setFocusable(true);
                }
            }
        });

        tvScore = (TextView) view.findViewById(R.id.tv_score);
        tvScore.setText(util.getScore()+"");
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ProfileUtil util = new ProfileUtil(getContext());
        tvScore.setText(util.getScore()+"");
    }
}
