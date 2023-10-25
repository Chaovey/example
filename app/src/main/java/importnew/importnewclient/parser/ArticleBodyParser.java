package importnew.importnewclient.parser;


import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import importnew.importnewclient.utils.Constants.Regex;

/**
 * Parsing an article from an HTML page
 * Created by Xingfeng on 2016/5/5.
 */
public class ArticleBodyParser {

    /**
     * Use regular expressions to remove useless parts from article HTML documents
     *
     * @param html article HTML document
     * @return The document after deletion
     */
    public static String parserArticleBody(String html) {

        if(TextUtils.isEmpty(html)){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        //Extract the header part
        Pattern pattern = Pattern.compile(Regex.BODY_HEAD, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(html);
        String left = "";
        while (matcher.find()) {
            sb.append(html.substring(0, matcher.end()));
            left = html.substring(matcher.end());
        }


        //Delete the top-nav node
        pattern = Pattern.compile(Regex.BODY_DELETE_TOPNAV,Pattern.DOTALL);
        matcher = pattern.matcher(left);
        while (matcher.find()) {
            sb.append(left.substring(0, matcher.start())).append("<br>");
            left = left.substring(matcher.end());
        }

        //Delete the header
        pattern = Pattern.compile(Regex.BODY_DELETE_HEAD, Pattern.DOTALL);
        matcher = pattern.matcher(left);
        while (matcher.find()) {
            sb.append(left.substring(0, matcher.start()));
            left = left.substring(matcher.end());
        }

        //Remove the entery-meta part
        pattern = Pattern.compile(Regex.BODY_DELETE_ENTRY_META, Pattern.DOTALL);
        matcher = pattern.matcher(left);
        while (matcher.find()) {
            sb.append(left.substring(0, matcher.start()));
            left = left.substring(matcher.end());
        }

        //Delete the tipping section of Bó Lè online articles, like and favorite buttons
        pattern = Pattern.compile(Regex.BODY_DELETE_REWARDS, Pattern.DOTALL);
        matcher = pattern.matcher(left);
        while (matcher.find()) {
            sb.append(left.substring(0, matcher.start()));
            left = left.substring(matcher.end());
        }


        //Extract the share, advertisement section at the end of the article
        pattern = Pattern.compile(Regex.BODY_DELETE_AD, Pattern.DOTALL);
        matcher = pattern.matcher(left);
        while (matcher.find()) {
            sb.append(left.substring(0, matcher.start()));
            left = left.substring(matcher.end());
        }

        //Delete the comments section
        pattern = Pattern.compile(Regex.BODY_DELETE_COMMENTS, Pattern.DOTALL);
        matcher = pattern.matcher(left);
        while (matcher.find()) {
            sb.append(left.substring(0, matcher.start()));
            left = left.substring(matcher.end());
        }

        //Remove the login section at the bottom of the Bó Lè online article
        pattern=Pattern.compile("<div id=\"article-comment\".+</div>",Pattern.DOTALL);
        matcher = pattern.matcher(left);
        while (matcher.find()) {
            sb.append(left.substring(0, matcher.start()));
            left = left.substring(matcher.end());
        }

        //Remove the sidebar section
        pattern = Pattern.compile(Regex.BODY_DELETE_SIDEBAR, Pattern.DOTALL);
        matcher = pattern.matcher(left);
        while (matcher.find()) {
            sb.append(left.substring(0, matcher.start()));
            left = left.substring(matcher.end());
        }

        //Remove the footer part
        pattern = Pattern.compile(Regex.BODY_DELETE_FOOTER, Pattern.DOTALL);
        matcher = pattern.matcher(left);
        while (matcher.find()) {
            sb.append(left.substring(0, matcher.start()));
            left = left.substring(matcher.end());
        }

        sb.append(left);

        return sb.toString();
    }

}
