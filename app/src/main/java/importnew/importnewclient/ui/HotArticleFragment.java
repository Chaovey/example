package importnew.importnewclient.ui;


import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import importnew.importnewclient.R;

/**
 * Popular article Fragment, contains two sub-fragments, monthly hot and year popular
 * A simple {@link Fragment} subclass.
 */
public class HotArticleFragment extends FragmentsGroup {

    @Override
    public int getPageTitleResourceId() {
        return R.array.hotArticlesPageTitle;
    }

    @Override
    public List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MonthHotFragment());
        fragments.add(new YearHotFragment());
        return fragments;
    }

}
