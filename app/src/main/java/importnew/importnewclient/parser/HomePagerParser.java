package importnew.importnewclient.parser;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import importnew.importnewclient.bean.Article;
import importnew.importnewclient.utils.Constants.Regex;

/**
 * Parse the Importnew homepage
 * Created by Xingfeng on 2016/4/28.
 */
public class HomePagerParser implements ArticlesParser {


    /**
     * Use regular expressions to parse documents and extract 5*5 articles from the first page
     *
     * @param html
     * @return
     */
    public List<Article> parser(String html) {

        List<Article> articleList = new ArrayList<>();
        Article article = null;

        String temp = null;
        try {
            Pattern pattern = Pattern.compile(Regex.HOME_ARTICLE);
            Matcher matcher = pattern.matcher(html);
            Pattern innerPattern = null;
            Matcher innerMatcher = null;
            while (matcher.find()) {
                temp = html.substring(matcher.start(), matcher.end());
                article = new Article();

                //文章URL
                innerPattern = Pattern.compile(Regex.HOME_ARTICLE_URL, Pattern.DOTALL);
                innerMatcher = innerPattern.matcher(temp);
                while (innerMatcher.find()) {
                    article.setUrl(temp.substring(innerMatcher.start() + 6, innerMatcher.end() - 1));
                }

                //文章标题
                innerPattern = Pattern.compile(Regex.HOME_ARTICLE_TITLE);
                innerMatcher = innerPattern.matcher(temp);
                while (innerMatcher.find()) {
                    article.setTitle(temp.substring(innerMatcher.start() + 7, innerMatcher.end() - 2));
                }

                //文章图片链接
                innerPattern = Pattern.compile(Regex.HOME_ARTICLE_IMG);
                innerMatcher = innerPattern.matcher(temp);
                while (innerMatcher.find()) {
                    article.setImgUrl(temp.substring(innerMatcher.start() + 5, innerMatcher.end()));
                }

                articleList.add(article);
                article = null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return articleList;
        }


        return articleList;

    }

}
