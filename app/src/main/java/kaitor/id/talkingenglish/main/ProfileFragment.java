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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import kaitor.id.talkingenglish.R;
import kaitor.id.talkingenglish.util.ProfileUtil;
import kaitor.id.talkingenglish.util.ProgressUtil;

/**
 * Created by user pc on 5/28/2016.
 */
public class ProfileFragment extends Fragment {
    private TextView tvScore;
    private ImageView imageHome,imageFruits,imageNumber,imageFamily,imageSchool,imageTransportation,imageLibrary,imageHobbies, imageSupermarket, imageFactory, imageHospital, imageTraffic;
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


        //Beginner
        imageHome = (ImageView) view.findViewById(R.id.image_home);
        imageFruits = (ImageView) view.findViewById(R.id.image_fruits);
        imageNumber = (ImageView) view.findViewById(R.id.image_number);
        imageFamily = (ImageView) view.findViewById(R.id.image_family);

        //Intermediate
        imageSchool = (ImageView) view.findViewById(R.id.image_school);
        imageTransportation = (ImageView) view.findViewById(R.id.image_transportation);
        imageLibrary = (ImageView) view.findViewById(R.id.image_library);
        imageHobbies = (ImageView) view.findViewById(R.id.image_hobbies);

        //Advanced
        imageSupermarket = (ImageView) view.findViewById(R.id.image_supermarket);
        imageFactory = (ImageView) view.findViewById(R.id.image_factory);
        imageTraffic = (ImageView) view.findViewById(R.id.image_traffic);
        imageHospital = (ImageView) view.findViewById(R.id.image_hospital);

        initBadges();
        tvScore = (TextView) view.findViewById(R.id.tv_score);
        tvScore.setText(util.getScore()+"");
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        initBadges();
        ProfileUtil util = new ProfileUtil(getContext());
        tvScore.setText(util.getScore()+"");
    }

    public void initBadges(){
        ProgressUtil progressUtil = new ProgressUtil(getContext());

        //Beginner
        if(progressUtil.getTopicStatus("home")){
            imageHome.setImageResource(R.drawable.home_badge);
        }
        if(progressUtil.getTopicStatus("fruits")){
            imageFruits.setImageResource(R.drawable.fruits_badge);
        }
        if(progressUtil.getTopicStatus("number")){
            imageNumber.setImageResource(R.drawable.number_badge);
        }
        if(progressUtil.getTopicStatus("family")){
            imageFamily.setImageResource(R.drawable.family_badge);
        }

        //Intermediate
        if(progressUtil.getTopicStatus("school")){
            imageSchool.setImageResource(R.drawable.school_badge);
        }
        if(progressUtil.getTopicStatus("transportation")){
            imageTransportation.setImageResource(R.drawable.transportation_badge);
        }
        if(progressUtil.getTopicStatus("library")){
            imageLibrary.setImageResource(R.drawable.library_badge);
        }
        if(progressUtil.getTopicStatus("hobbies")){
            imageHobbies.setImageResource(R.drawable.hobbies_badge);
        }

        //Advanced
        if(progressUtil.getTopicStatus("supermarket")){
            imageSupermarket.setImageResource(R.drawable.supermarket_badge);
        }
        if(progressUtil.getTopicStatus("factory")){
            imageFactory.setImageResource(R.drawable.factory_badge);
        }
        if(progressUtil.getTopicStatus("traffic")){
            imageTraffic.setImageResource(R.drawable.traffic_badge);
        }
        if(progressUtil.getTopicStatus("hospital")){
            imageHospital.setImageResource(R.drawable.hospital_badge);
        }

    }

}
