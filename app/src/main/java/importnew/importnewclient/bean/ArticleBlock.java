package importnew.importnewclient.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Article block, parse the results of the homepage
 * Created by Xingfeng on 2016/4/30.
 */
public class ArticleBlock {


    /**
     * Article classification
     */
    private String category;

    /**
     * A collection of articles
     */
    private List<Article> articles;


    public ArticleBlock() {
        articles = new ArrayList<>();
    }

    public ArticleBlock(String category, List<Article> articles) {
        this.category = category;
        this.articles = articles;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
