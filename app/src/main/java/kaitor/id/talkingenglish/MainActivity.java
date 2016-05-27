package kaitor.id.talkingenglish;

import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kaitor.id.talkingenglish.main.ExampleFragment;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(),R.id.main_content);

//        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
//                FragmentStackSupport.CountingFragment.class, null);

        mTabHost.addTab(mTabHost.newTabSpec("Contoh").setIndicator("Contoh"), ExampleFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("Contoh1").setIndicator("Contoh1"), ExampleFragment.class,null);
        mTabHost.addTab(mTabHost.newTabSpec("Contoh2").setIndicator("Contoh23"), ExampleFragment.class,null);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mTabHost.addTab(mTabHost.newTabSpec("Yow").setIndicator("",getResources().getDrawable(R.drawable.firstaid,null)), ExampleFragment.class,null);
        }
        else{
            mTabHost.addTab(mTabHost.newTabSpec("Yow").setIndicator("",getResources().getDrawable(R.drawable.firstaid)),ExampleFragment.class,null);
        }

    }
}
