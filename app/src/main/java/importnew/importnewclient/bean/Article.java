package importnew.importnewclient.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Article entity class
 * Created by Xingfeng on 2016/4/30.
 */
public class Article implements Parcelable {

    /**
     * Article URL
     */
    private String url;

    /**
     * Article image URL
     */
    private String imgUrl="";

    /**
     * Article title
     */
    private String title;

    /**
     * Introduction to the article
     */
    private String desc;


    protected Article(Parcel in) {
        url = in.readString();
        imgUrl = in.readString();
        title = in.readString();
        desc = in.readString();
        commentNum = in.readString();
        date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(imgUrl);
        dest.writeString(title);
        dest.writeString(desc);
        dest.writeString(commentNum);
        dest.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };


    /**
     * Number of comments
     */
    private String commentNum;

    /**
     * Article date
     */
    private String date;

    public Article() {
    }

    public Article(String url, String imgUrl, String title, String desc, String commentNum, String date) {
        this.url = url;
        this.imgUrl = imgUrl;
        this.title = title;
        this.desc = desc;
        this.commentNum = commentNum;
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {

        if (imgUrl.matches("((http)|(www)).+\\.((png)|(jpeg)|(jpg)|(gif))")) {
            this.imgUrl = imgUrl;
        } else {

            Pattern pattern = Pattern.compile("www.+\\.((png)|(jpeg)|(jpg)|(gif))");
            Matcher matcher = pattern.matcher(imgUrl);
            while (matcher.find()) {
                this.imgUrl = "http://"+imgUrl.substring(matcher.start(), matcher.end());
            }

        }

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * If the URL of two articles is the same, the articles are considered equal
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        return url.equals(article.url);

    }


    @Override
    public String toString() {
        return "Article{" +
                "url='" + url + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", commentNum=" + commentNum +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return url.hashCode();
    }
}
