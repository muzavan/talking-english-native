package kaitor.id.talkingenglish.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kaitor.id.talkingenglish.R;

/**
 * Created by user pc on 5/27/2016.
 */
public class ExampleFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_example,container,false);
        return view;
    }
}
