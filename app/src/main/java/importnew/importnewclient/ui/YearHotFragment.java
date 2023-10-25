package importnew.importnewclient.ui;


import importnew.importnewclient.presenter.HotArticlePresenter;
import importnew.importnewclient.presenter.YearHotArticlePresenter;
import importnew.importnewclient.view.IHotArticleView;

/**
 * Top article of the year
 */
public class YearHotFragment extends AbstractHotFragment implements IHotArticleView {

    @Override
    public HotArticlePresenter getHotArticlePresenter() {
        return new YearHotArticlePresenter(this);
    }
}
