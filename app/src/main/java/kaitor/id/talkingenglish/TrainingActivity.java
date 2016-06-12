package kaitor.id.talkingenglish;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import kaitor.id.talkingenglish.util.ProfileUtil;
import kaitor.id.talkingenglish.welcome.ReadyFragment;
import kaitor.id.talkingenglish.welcome.WelcomeFragment;

public class TrainingActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 3;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    private ImageView imageWelcomeMarker1, imageWelcomeMarker2, imageWelcomeMarker3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkLogin();
        setContentView(R.layout.activity_welcome);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);



        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setDefaultMarker();
                setActiveMarker(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // Instantiate Marker
        imageWelcomeMarker1 = (ImageView) findViewById(R.id.image_welcome_marker_1);
        imageWelcomeMarker2 = (ImageView) findViewById(R.id.image_welcome_marker_2);
        imageWelcomeMarker3 = (ImageView) findViewById(R.id.image_welcome_marker_3);


        setDefaultMarker();
        setActiveMarker(0);
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private void checkLogin() {
        ProfileUtil util = new ProfileUtil(getApplicationContext());
        if (util.isLogin()) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void setDefaultMarker() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            imageWelcomeMarker1.setColorFilter(getResources().getColor(R.color.marker_gray, null));
            imageWelcomeMarker2.setColorFilter(getResources().getColor(R.color.marker_gray, null));
            imageWelcomeMarker3.setColorFilter(getResources().getColor(R.color.marker_gray, null));
        } else {
            imageWelcomeMarker1.setColorFilter(getResources().getColor(R.color.marker_gray));
            imageWelcomeMarker2.setColorFilter(getResources().getColor(R.color.marker_gray));
            imageWelcomeMarker3.setColorFilter(getResources().getColor(R.color.marker_gray));
        }
    }

    private void setActiveMarker(int position) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            switch (position) {
                case 0:
                    imageWelcomeMarker1.setColorFilter(getResources().getColor(R.color.marker_white, null));
                    break;
                case 1:
                    imageWelcomeMarker2.setColorFilter(getResources().getColor(R.color.marker_white, null));
                    break;
                default:
                    imageWelcomeMarker3.setColorFilter(getResources().getColor(R.color.marker_white, null));
                    break;
            }
        } else {
            switch (position) {
                case 0:
                    imageWelcomeMarker1.setColorFilter(getResources().getColor(R.color.marker_white));
                    break;
                case 1:
                    imageWelcomeMarker2.setColorFilter(getResources().getColor(R.color.marker_white));
                    break;
                default:
                    imageWelcomeMarker3.setColorFilter(getResources().getColor(R.color.marker_white));
                    break;
            }

        }
    }


    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            Fragment fragment;
            if (position < 2) {
                fragment = WelcomeFragment.newInstance(position);
            } else {
                fragment = ReadyFragment.newInstance();
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
