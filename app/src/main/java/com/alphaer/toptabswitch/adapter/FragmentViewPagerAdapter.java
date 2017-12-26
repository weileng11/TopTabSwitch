package com.alphaer.toptabswitch.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by zhong on 2015/10/22.
 * ViewPager的适配器
 */
public class FragmentViewPagerAdapter extends FragmentPagerAdapter {

    //需要显示的Fragment
    private List<Fragment> fragments;

    public FragmentViewPagerAdapter(FragmentManager fm,List<Fragment> fragments){
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        //得到具体的Fragment
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        //返回数量
        return fragments.size();
    }
}
