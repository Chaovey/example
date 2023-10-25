package importnew.importnewclient.view;


import android.widget.ListAdapter;

/**
 * Categorize the list of articles Fragment or Activity corresponding to View
 * Created by Xingfeng on 2017-02-14.
 */
public interface IArticieListView extends IBaseView {

    void setAdapter(ListAdapter adapter);

    /**
     * Determine whether it is currently in the loading phase
     *
     * @return true Indicates loading
     */
    boolean isLoading();

    /**
     * No more articles are set to load
     */
    void setNoContentToLoad();

    /**
     * ListView Set the selected Item position
     *
     * @param selection
     */
    void setSelection(int selection);

    void setLoading(boolean isLoading);

}
