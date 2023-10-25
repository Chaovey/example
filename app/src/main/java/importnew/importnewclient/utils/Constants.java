package importnew.importnewclient.utils;

/**
 * Constant value class
 * Created by Xingfeng on 2016/5/10.
 */
public class Constants {

    public static boolean IS_SAVE_FLOW = false;

    /**
     * key
     */
    public static class Key {

        public static final String SELECTION = "listview_selection";
        /**
         * essay
         */
        public static final String ARTICLE = "article";

        public static final String ARTICLE_URL = "article_url";
        /**
         * The main content of the article
         */
        public static final String ARTICLE_BODY = "article_body";

        /**
         * Favorites or not
         */
        public static final String IS_FAVOURITE = "is_favourite";

        /**
         * List of articles
         */
        public static final String ARTICLE_LIST = "article_list";

        /**
         * The number of article pages
         */
        public static final String PAGE_NUM = "page_num";

        public static final String ARTICLE_BASE_URL = "article_base_url";

        public static final String NUM_OF_FRAGMENT = "num_of_fragment";

        public static final String UPDATE_INFO = "updateInfo";

        public static final String PICTURE_URL = "picture_url";

        /**
         * Data saving mode
         */
        public static String IS_SAVE_FLOW_MODE = "is_save_flow_mode";

        /**
         * Night mode
         */
        public static String IS_NIGHT_MODE = "is_night_mode";
    }


    /**
     * Status code
     */
    public static class Code {

        public static final int REQUEST_CODE = 24;

    }


    /**
     * Regular expression labels
     */
    public static class Regex {

        /**
         * The main body of the article on the home page
         */
        public static final String HOME_ARTICLE = "<a\\s+target.*href.*title.*<img.*></a>";

        /**
         * Homepage article link
         */
        public static final String HOME_ARTICLE_URL = "href.+\\.html\"";

        /**
         * Homepage article title
         */
        public static final String HOME_ARTICLE_TITLE = "title.*\">";

        /**
         * Homepage article image link
         */
        public static final String HOME_ARTICLE_IMG = "src.*\\.((jpg)|(png)|(gif)|(jpeg))";

        /**
         * Article list article body
         */
        public static final String LIST_ARTICLES_BODY = "(<!-- BEGIN .post -->).*((<!-- END .post -->))+?";

        /**
         * Article list separator
         */
        public static final String LIST_ARTICLES_SPLIT = "<!-- END .post -->";

        public static final String LIST_ARTICLES_IMG_BLOCK = "<a.*<img.*></a>";
        public static final String LIST_ARTICLES_URL = "href=\".+?\"";
        public static final String LIST_ARTICLES_TITLE = "title=\\\".*\\\">";
        public static final String LIST_ARTICLES_IMG = "src=\".+?(\")";
        public static final String LIST_ARTICLES_COMMENT_DATE = "<p><a.*?</p>";
        public static final String LIST_ARTICLES_DATE = "\\d{4}/\\d{1,2}/\\d{1,2}";
        public static final String LIST_ARTICLES_COMMENT = "\\d+ 条评论";
        public static final String LIST_ARTICLES_DESC = "<p>[^<].+</p>";

        /**
         * head
         */
        public static final String BODY_HEAD = "<!DOCTYPE.+</head>";


        /**
         * The removed header
         */
        public static final String BODY_DELETE_HEAD = "<!-- BEGIN header -->.+<!-- END header -->";


        /**
         * Remove entry-meta
         */
        public static final String BODY_DELETE_ENTRY_META = "<!-- BEGIN \\.entry-meta -->.+<!-- END \\.entry-meta -->";


        /**
         * Remove the advertising section at the end of the article
         */
        public static final String BODY_DELETE_AD = "<!-- JiaThis Button BEGIN -->.+<!-- END \\.post -->";

        /**
         * Delete the comments section
         */
        public static final String BODY_DELETE_COMMENTS = "<!-- BEGIN #respond -->.+<!-- END \\.navigation -->";

        /**
         * Delete the article Sidebar
         */
        public static final String BODY_DELETE_SIDEBAR = "<!-- BEGIN #sidebar -->.+<!-- END #sidebar -->";


        /**
         * Remove the article footer
         */
        public static final String BODY_DELETE_FOOTER = "<!-- BEGIN footer -->.+<!-- END footer -->";

        /**
         * Remove the article top-nav node
         */
        public static final String BODY_DELETE_TOPNAV = "<nav id.+<!-- END #top-nav -->";

        /**
         * Remove the article tipping section
         */
        public static final String BODY_DELETE_REWARDS = "<blockquote class=\"rewards\".*</blockquote>.*<!-- BEGIN #author-bio -->";

        /**
         * ImportNew article identification
         */
        public static final String IS_ARTICLE_URL = "http.+((importnew)|(jobbole))\\.com/\\d{2,}+";

        /**
         * ImportNew image logo
         */
        public static final String IS_PICTURE_URL = "http.+\\.((png)|(jpg)|(jpeg)|(gif))";
    }
}
