package importnew.importnewclient.view;

import android.widget.ListAdapter;

/**
 * The View interface corresponding to the home page fragment
 * Created by Xingfeng on 2017-02-14.
 */
public interface IHomePageView extends IBaseView {

    /**
     * Set the ListView's adapter
     *
     * @param adapter
     */
    void setAdapter(ListAdapter adapter);

}
