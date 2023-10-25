package importnew.importnewclient.view;


import android.support.v7.widget.RecyclerView;

/**
 * Created by Xingfeng on 2017-02-15.
 */

public interface IHotArticleView extends IBaseView {

    /**
     * Set the visibility of the RecycleView
     *
     * @param visible
     */
    void setRecycleViewVisibility(int visible);

    /**
     * Set the RecycleView adapter
     *
     * @param adapter
     */
    void setAdapter(RecyclerView.Adapter adapter);

}
