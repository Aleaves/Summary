package com.app.liulongbing.beam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.app.liulongbing.beam.image.ImageJoyFragment;
import com.app.liulongbing.beam.text.TextJoyFragment;
import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.BeamBaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

@RequiresPresenter(MainPresenter.class)
public class MainActivity extends BeamBaseActivity<MainPresenter> {


    @Bind(R.id.viewPager)
    ViewPager viewpager;
    @Bind(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @Bind(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;

    private MainPagerAdapter mMainPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("豆逼  —  给你纯粹的欢乐");
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tabLayout.setTabTextColors(getResources().getColor(R.color.whiteTrans80), getResources().getColor(R.color.white));
        viewpager.setAdapter(mMainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewpager);

        Log.i("======","Main==onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("======","Main==onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("======","Main==onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("======","Main==onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("======","Main==onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("======","Main==onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("======","Main==onDestory ");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public class MainPagerAdapter extends FragmentStatePagerAdapter{

        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TextJoyFragment();
                default:
                    return new ImageJoyFragment();
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "段子";
                case 1:
                    return "图片";
                default:
                    return "推荐";
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
