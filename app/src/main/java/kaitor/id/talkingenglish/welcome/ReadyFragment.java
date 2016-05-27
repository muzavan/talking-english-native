package kaitor.id.talkingenglish.welcome;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kaitor.id.talkingenglish.MainActivity;
import kaitor.id.talkingenglish.R;
import kaitor.id.talkingenglish.util.ProfileUtil;

/**
 * Created by user pc on 5/27/2016.
 */
public class ReadyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ready,container,false);
        Button buttonStart = (Button) view.findViewById(R.id.button_start);
        final EditText editName = (EditText) view.findViewById(R.id.edit_name);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editName.getText().toString().equals("")){
                    // Name has not been inputed
                    editName.setHighlightColor(Color.RED);
                    Toast.makeText(getContext(), "Input your name first.", Toast.LENGTH_SHORT).show();
                }
                else{
                    ProfileUtil util = new ProfileUtil(getContext());
                    util.setName(editName.getText().toString());
                    Intent intent = new Intent(getActivity(),MainActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
            }
        });
        return view;
    }

    public static ReadyFragment newInstance() {
        
        Bundle args = new Bundle();
        
        ReadyFragment fragment = new ReadyFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
