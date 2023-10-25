package importnew.importnewclient.utils;

import java.util.ArrayList;
import java.util.List;

import importnew.importnewclient.bean.Article;
import importnew.importnewclient.bean.ArticleBlock;

/**
 * Convert a list of articles into a list of article blocks
 * Created by Xingfeng on 2016/5/14.
 */
public class ArctileBlockConverter {

    public static final String[] titles = {"Recommended reading", "Latest articles", "Java dry goods", "Industry dynamics", "Underlying technology"};

    public static List<ArticleBlock> converter(List<Article> articleList) {

        List<ArticleBlock> articleBlockList = new ArrayList<>();
        ArticleBlock articleBlock = null;
        for (int i = 0; i < articleList.size(); i++) {
            if (i % 5 == 0) {
                articleBlock = new ArticleBlock();
                articleBlock.setCategory(titles[i/5]);
                articleBlockList.add(articleBlock);
            }

            articleBlock.addArticle(articleList.get(i));

        }

        return articleBlockList;

    }


}
