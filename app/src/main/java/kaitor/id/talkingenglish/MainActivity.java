package kaitor.id.talkingenglish;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;
import android.widget.TabHost;

import kaitor.id.talkingenglish.main.ExampleFragment;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.main_content);

//        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
//                FragmentStackSupport.CountingFragment.class, null);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mTabHost.addTab(mTabHost.newTabSpec("Learn").setIndicator("", getResources().getDrawable(R.drawable.ic_class_black_24dp, null)), ExampleFragment.class, null);
            mTabHost.addTab(mTabHost.newTabSpec("Profile").setIndicator("", getResources().getDrawable(R.drawable.ic_face_black_24dp, null)), ExampleFragment.class, null);
            mTabHost.addTab(mTabHost.newTabSpec("Dictionary").setIndicator("", getResources().getDrawable(R.drawable.ic_search_black_24dp, null)), ExampleFragment.class, null);
        } else {
            mTabHost.addTab(mTabHost.newTabSpec("Learn").setIndicator("", getResources().getDrawable(R.drawable.ic_class_black_24dp)), ExampleFragment.class, null);
            mTabHost.addTab(mTabHost.newTabSpec("Profile").setIndicator("", getResources().getDrawable(R.drawable.ic_face_black_24dp)), ExampleFragment.class, null);
            mTabHost.addTab(mTabHost.newTabSpec("Dictionary").setIndicator("", getResources().getDrawable(R.drawable.ic_search_black_24dp)), ExampleFragment.class, null);
        }

        mTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                for(int i=0;i<mTabHost.getTabWidget().getChildCount();i++){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        mTabHost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.fragment_welcome_background,null));
                    }
                    else{
                        mTabHost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.fragment_welcome_background));
                    }
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mTabHost.getCurrentTabView().setBackgroundColor(getResources().getColor(R.color.marker_white,null));
                }
                else{
                    mTabHost.getCurrentTabView().setBackgroundColor(getResources().getColor(R.color.marker_white));
                }
            }
        });

    }
}
