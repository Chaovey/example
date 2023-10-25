package importnew.importnewclient.ui;


import importnew.importnewclient.presenter.HotArticlePresenter;
import importnew.importnewclient.presenter.MonthHotArticlePresenter;
import importnew.importnewclient.view.IHotArticleView;

/**
 * Popular articles of the month
 */
public class MonthHotFragment extends AbstractHotFragment implements IHotArticleView {

    @Override
    public HotArticlePresenter getHotArticlePresenter() {
        return new MonthHotArticlePresenter(this);
    }
}
