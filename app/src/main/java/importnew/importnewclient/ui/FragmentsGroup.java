package importnew.importnewclient.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import importnew.importnewclient.R;

/**
 * The parent class of a fragment that contains multiple lists of articles, which can contain fragments internally
 * Created by Xingfeng on 2017-02-15.
 */
public abstract class FragmentsGroup extends BaseFragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<Fragment> fragments;
    private String[] pageTitles;

    private FragmentStatePagerAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_all_articles, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        mTabLayout.setTabMode(getTabMode());
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        initDatas();
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initDatas() {

        pageTitles = getResources().getStringArray(getPageTitleResourceId());
        fragments = getFragments();
        mAdapter = new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return pageTitles[position];
            }
        };

    }

    /**
     * Returns the mode of TabLayout, which defaults to a fixed size
     *
     * @return
     */
    public int getTabMode() {
        return TabLayout.MODE_FIXED;
    }

    /**
     * Get the PageTitle resource Id
     *
     * @return
     */
    public abstract int getPageTitleResourceId();

    /**
     * Get the fragments contained inside
     *
     * @return
     */
    public abstract List<Fragment> getFragments();
}
