package com.alphaer.toptabswitch;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.alphaer.toptabswitch.adapter.FragmentViewPagerAdapter;
import com.alphaer.toptabswitch.fragments.FirstFragment;
import com.alphaer.toptabswitch.fragments.SecondFragment;
import com.alphaer.toptabswitch.fragments.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private TextView tvTab1,tvTab2,tvTab3;
    private int currIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setContentView(R.layout.activity_main);
        initView();
        initViewPager();
    }

    private void initView(){
        tvTab1= (TextView) findViewById(R.id.tv_tab1);
        tvTab2= (TextView) findViewById(R.id.tv_tab2);
        tvTab3= (TextView) findViewById(R.id.tv_tab3);

        tvTab1.setOnClickListener(new tvOnClickListener(0));
        tvTab2.setOnClickListener(new tvOnClickListener(1));
        tvTab3.setOnClickListener(new tvOnClickListener(2));
    }

    //textView的监听器，当按下textview控件时，可跳转到对应Fragment。
    private class tvOnClickListener implements View.OnClickListener{

        private int index=0;

        public tvOnClickListener(int index){
            this.index=index;
        }

        @Override
        public void onClick(View view) {
            viewPager.setCurrentItem(index);
        }
    }

    private void initViewPager(){
        viewPager= (ViewPager) findViewById(R.id.viewpager);
        fragmentList=new ArrayList<Fragment>();
        fragmentList.add(new FirstFragment());
        fragmentList.add(new SecondFragment());
        fragmentList.add(new ThirdFragment());

        //设置适配器
        viewPager.setAdapter(new FragmentViewPagerAdapter(getSupportFragmentManager(), fragmentList));
        viewPager.setCurrentItem(0);
        tvTab1.setTextColor(Color.RED);
        //设置监听
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
    }

    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currIndex=position;
            //使TextView改变颜色，指示现在是哪个Fragment。
            switch (position){
                case 0:
                    tvTab1.setTextColor(Color.RED);
                    tvTab2.setTextColor(Color.WHITE);
                    tvTab3.setTextColor(Color.WHITE);
                    break;
                case 1:
                    tvTab1.setTextColor(Color.WHITE);
                    tvTab2.setTextColor(Color.RED);
                    tvTab3.setTextColor(Color.WHITE);
                    break;
                case 2:
                    tvTab1.setTextColor(Color.WHITE);
                    tvTab2.setTextColor(Color.WHITE);
                    tvTab3.setTextColor(Color.RED);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
