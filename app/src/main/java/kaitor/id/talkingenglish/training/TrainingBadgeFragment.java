package kaitor.id.talkingenglish.training;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kaitor.id.talkingenglish.R;

/**
 * Created by user pc on 6/12/2016.
 */
public class TrainingBadgeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_training_badge,container,false);
        TextView tvBadge = (TextView) view.findViewById(R.id.tv_get_badge);
        Typeface typef = Typeface.createFromAsset(getContext().getAssets(),"font/Moon Flower Bold.ttf");
        tvBadge.setTypeface(typef);
        return view;
    }
}
