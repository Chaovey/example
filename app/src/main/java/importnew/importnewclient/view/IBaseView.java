package importnew.importnewclient.view;

/**
 * The base class of View in the MVP structure
 * Created by Xingfeng on 2017-02-14.
 */
public interface IBaseView {

    /**
     * Controls whether SwipeRefreshLayout is displayed
     *
     * @param isRefresh true means display, false means no yes is selected
     */
    void setRefreshing(boolean isRefresh);

    /**
     * Toast An error message is displayed
     * @param message Prompt message
     */
    void showErrorInfo(String message);

}
