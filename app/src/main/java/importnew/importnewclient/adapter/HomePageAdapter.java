package importnew.importnewclient.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import importnew.importnewclient.R;
import importnew.importnewclient.bean.Article;
import importnew.importnewclient.bean.ArticleBlock;
import importnew.importnewclient.utils.ListViewUtil;

/**
 * Created by Xingfeng on 2016/4/30.
 */
public class HomePageAdapter extends BaseAdapter {


    private List<ArticleBlock> articleBlocks;

    private Activity activity;

    private LayoutInflater mInflater;
    /**
     * Select the article
     */
    private Article selectedArticle;

    private List<ArticleBlockAdapter> adapters;

    public HomePageAdapter(Activity activity, List<ArticleBlock> datas) {
        this.activity = activity;
        this.articleBlocks = datas;

        adapters = new ArrayList<>();
        mInflater = LayoutInflater.from(activity);

    }


    /**
     * Synchronize cache records to the journal file
     */
    public void flushCache() {
        if (adapters != null) {
            for (ArticleBlockAdapter adapter : adapters) {
                adapter.flushCache();
            }
        }
    }

    @Override
    public int getCount() {
        return articleBlocks.size();
    }

    @Override
    public Object getItem(int position) {
        return articleBlocks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = mInflater.inflate(R.layout.article_block_layout, parent, false);
        ListView listView = (ListView) convertView.findViewById(R.id.article_block_listview);
        ArticleBlockAdapter adapter = new ArticleBlockAdapter(activity, listView, articleBlocks.get(position));
        listView.setAdapter(adapter);
        ListViewUtil.setListViewHeightBasedOnItems(listView);
        adapters.add(adapter);
        return convertView;

    }


    /**
     * Cancel all tasks that are downloading or waiting to be downloaded
     */
    public void cancelAllTasks() {
        if (adapters != null) {
            for (ArticleBlockAdapter adapter : adapters) {
                adapter.cancelAllTasks();
            }
        }
    }

}
