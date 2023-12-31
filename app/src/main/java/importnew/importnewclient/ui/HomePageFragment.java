package importnew.importnewclient.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import importnew.importnewclient.R;
import importnew.importnewclient.presenter.HomePagePresenter;
import importnew.importnewclient.view.IHomePageView;


/**
 * Home Fragment
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends BaseFragment implements IHomePageView {

    private SwipeRefreshLayout mRefreshLayout;
    private ListView mArticleBlokcListView;
    private HomePagePresenter mHomePagePresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.homepage_swiperefresh);
        mRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        mRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics()));

        mRefreshLayout.setEnabled(true);
        mRefreshLayout.setRefreshing(true);
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mHomePagePresenter.getHtmlAndParser(true);
            }
        });

        mArticleBlokcListView = (ListView) view.findViewById(R.id.article_block_listview);

        mHomePagePresenter = new HomePagePresenter(this);

        mHomePagePresenter.getHtmlAndParser(false);

    }


    @Override
    public void setRefreshing(boolean isRefresh) {
        mRefreshLayout.setRefreshing(isRefresh);
    }

    @Override
    public void showErrorInfo(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();

        mRefreshLayout.setRefreshing(false);
        mHomePagePresenter.flushCache();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRefreshLayout.setRefreshing(false);
        mHomePagePresenter.cancelAllTasks();
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        mArticleBlokcListView.setAdapter(adapter);
    }
}
