package importnew.importnewclient.presenter;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import importnew.importnewclient.adapter.HomePageAdapter;
import importnew.importnewclient.bean.ArticleBlock;
import importnew.importnewclient.net.URLManager;
import importnew.importnewclient.parser.ArticlesParser;
import importnew.importnewclient.parser.HomePagerParser;
import importnew.importnewclient.utils.ArctileBlockConverter;
import importnew.importnewclient.utils.SecondCache;
import importnew.importnewclient.view.IHomePageView;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Xingfeng on 2017-02-14.
 */

public class HomePagePresenter {

    private IHomePageView mHomePageView;
    private SecondCache mSecondCache;
    private List<ArticleBlock> mArticleBlocks;
    private HomePageAdapter mHomePageAdapter;

    public HomePagePresenter(IHomePageView mHomePageView) {
        this.mHomePageView = mHomePageView;
        Fragment fragment = (Fragment) mHomePageView;
        mSecondCache = new SecondCache(fragment.getActivity());

        mArticleBlocks = new ArrayList<>();
        mHomePageAdapter = new HomePageAdapter(fragment.getActivity(), mArticleBlocks);
        mHomePageView.setAdapter(mHomePageAdapter);
    }

    public void cancelAllTasks() {
        if (mHomePageAdapter != null) {
            mHomePageAdapter.cancelAllTasks();
        }
    }

    public void flushCache() {
        if (mHomePageAdapter != null) {
            mHomePageAdapter.flushCache();
        }
    }

    public void getHtmlAndParser(final boolean isRefresh) {
        mHomePageView.setRefreshing(true);
        Observable.create(new Observable.OnSubscribe<List<ArticleBlock>>() {
            @Override
            public void call(Subscriber<? super List<ArticleBlock>> subscriber) {

                String html = "";

                if (isRefresh) {
                    html = mSecondCache.getResponseFromNetwork(URLManager.HOMEPAGE);
                }

                if (TextUtils.isEmpty(html)) {
                    html = mSecondCache.getResponseString(URLManager.HOMEPAGE);
                }

                if (TextUtils.isEmpty(html)) {
                    subscriber.onError(new NullPointerException("Not resolved to the body of the article"));
                } else {
                    ArticlesParser homePageParser = new HomePagerParser();
                    subscriber.onNext(ArctileBlockConverter.converter(homePageParser.parser(html)));
                }

                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ArticleBlock>>() {
                    @Override
                    public void onCompleted() {

                        mHomePageView.setRefreshing(false);
                        mHomePageAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onError(Throwable e) {
                        mHomePageView.setRefreshing(false);
                        mHomePageView.showErrorInfo("An error occurred in loading the home page, please refresh and try again");
                    }

                    @Override
                    public void onNext(List<ArticleBlock> articleBlocks) {

                        mArticleBlocks.clear();
                        mArticleBlocks.addAll(articleBlocks);
                    }
                });
    }
}
