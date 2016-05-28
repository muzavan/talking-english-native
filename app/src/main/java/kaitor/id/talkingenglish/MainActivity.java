package kaitor.id.talkingenglish;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.Toolbar;
import android.widget.TabHost;

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
        toolbar.setTitle("Learn");

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.main_content);

        Drawable learnIcon,profileIcon,dictionaryIcon;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            learnIcon = getDrawable(R.drawable.ic_class_black_24dp);
            profileIcon = getDrawable(R.drawable.ic_face_black_24dp);
            dictionaryIcon = getDrawable(R.drawable.ic_search_black_24dp);
        }
        else{
            learnIcon = getResources().getDrawable(R.drawable.ic_class_black_24dp);
            profileIcon = getResources().getDrawable(R.drawable.ic_face_black_24dp);
            dictionaryIcon = getResources().getDrawable(R.drawable.ic_search_black_24dp);
        }
        mTabHost.addTab(mTabHost.newTabSpec("Learn").setIndicator("",learnIcon),LearnFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("Profile").setIndicator("",profileIcon), ProfileFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("Dictionary").setIndicator("",dictionaryIcon),DictionaryFragment.class,null);
        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                toolbar.setTitle(mTabHost.getCurrentTabTag());
                mTabHost.clearFocus();
            }
        });

    }
}
