package kaitor.id.talkingenglish;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import kaitor.id.talkingenglish.main.DictionaryFragment;
import kaitor.id.talkingenglish.main.LearnFragment;
import kaitor.id.talkingenglish.main.ProfileFragment;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        final TextView toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        toolbarTitle.setText("Learn");

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.main_content);

        View v0 = View.inflate(getBaseContext(),R.layout.tab_indicatior,null);
        View v1 = View.inflate(getBaseContext(),R.layout.tab_indicatior,null);
        View v2 = View.inflate(getBaseContext(),R.layout.tab_indicatior,null);

        ImageView iconV0 = (ImageView) v0.findViewById(R.id.image_indicator);
        iconV0.setImageResource(R.drawable.ic_class_black_24dp);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            iconV0.setColorFilter(getColor(R.color.marker_white));
        }
        else{
            iconV0.setColorFilter(getResources().getColor(R.color.marker_white));
        }
        ImageView iconV1 = (ImageView) v1.findViewById(R.id.image_indicator);
        iconV1.setImageResource(R.drawable.ic_face_black_24dp);
        ImageView iconV2 = (ImageView) v2.findViewById(R.id.image_indicator);
        iconV2.setImageResource(R.drawable.ic_search_black_24dp);

        mTabHost.addTab(mTabHost.newTabSpec("Learn").setIndicator(v0),LearnFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("Profile").setIndicator(v1), ProfileFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("Dictionary").setIndicator(v2),DictionaryFragment.class,null);
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                toolbarTitle.setText(mTabHost.getCurrentTabTag());
                initTab();
                ImageView image = (ImageView) mTabHost.getCurrentTabView().findViewById(R.id.image_indicator);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    image.setColorFilter(getColor(R.color.marker_white));
                }
                else{
                    image.setColorFilter(getResources().getColor(R.color.marker_white));
                }
                mTabHost.clearFocus();
            }
        });

    }

    private void initTab(){
        ImageView iconV0 = (ImageView) mTabHost.getTabWidget().getChildAt(0).findViewById(R.id.image_indicator);
        ImageView iconV1 = (ImageView) mTabHost.getTabWidget().getChildAt(1).findViewById(R.id.image_indicator);
        ImageView iconV2 = (ImageView) mTabHost.getTabWidget().getChildAt(2).findViewById(R.id.image_indicator);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            iconV0.setColorFilter(getColor(R.color.black));
            iconV1.setColorFilter(getColor(R.color.black));
            iconV2.setColorFilter(getColor(R.color.black));
        }
        else{
            iconV0.setColorFilter(getResources().getColor(R.color.black));
            iconV1.setColorFilter(getResources().getColor(R.color.black));
            iconV2.setColorFilter(getResources().getColor(R.color.black));
        }
    }
}
