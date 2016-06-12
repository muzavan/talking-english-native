package kaitor.id.talkingenglish.welcome;

import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kaitor.id.talkingenglish.R;

/**
 * Created by user pc on 5/27/2016.
 */
public class WelcomeFragment extends Fragment {
    public int type = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_welcome,container,false);
        TextView tvWelcomeCaption = (TextView) view.findViewById(R.id.tv_welcome_caption);
        ImageView imageWelcome = (ImageView) view.findViewById(R.id.image_welcome);
        TextView tvWelcomeDetails = (TextView) view.findViewById(R.id.id_welcome_details);
        TextView tvWelcome = (TextView) view.findViewById(R.id.tv_welcome);
        Typeface typef = Typeface.createFromAsset(getContext().getAssets(),"font/Moon Flower Bold.ttf");
        tvWelcome.setTypeface(typef);

        if(type == 0){
            tvWelcomeCaption.setText(getResources().getString(R.string.welcome_caption_0));
            tvWelcomeDetails.setText(getResources().getString(R.string.welcome_details_0));
            imageWelcome.setImageResource(R.drawable.book_open);
        }
        else{
            tvWelcomeCaption.setText(getResources().getString(R.string.welcome_caption_1));
            tvWelcomeDetails.setText(getResources().getString(R.string.welcome_details_1));
            imageWelcome.setImageResource(R.drawable.play);
        }

        return view;
    }

    public static WelcomeFragment newInstance(int type) {

        Bundle args = new Bundle();
        WelcomeFragment fragment = new WelcomeFragment();
        fragment.setArguments(args);
        fragment.type = type;
        return fragment;
    }
}
