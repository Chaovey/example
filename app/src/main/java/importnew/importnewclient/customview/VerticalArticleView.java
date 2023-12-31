package importnew.importnewclient.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import importnew.importnewclient.R;
import importnew.importnewclient.bean.Article;


/**
 * Vertically laid out article view with the article image at the top and the article title at the bottom
 * Created by Xingfeng on 2016/4/30.
 */
public class VerticalArticleView extends FrameLayout {

    private LayoutInflater mInfalter;

    private ImageView mArticleImg;
    private TextView mArticleTitle;
    private Article mArticle;//Associated articles

    public VerticalArticleView(Context context) {
        this(context, null);
    }

    public VerticalArticleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerticalArticleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInfalter = LayoutInflater.from(context);
        View rootView = mInfalter.inflate(R.layout.article_vertical_layout, this);
        mArticleImg = (ImageView) rootView.findViewById(R.id.article_img);
        mArticleTitle = (TextView) rootView.findViewById(R.id.article_title);
    }

    public void setImageResource(int resId) {
        mArticleImg.setImageResource(resId);
    }

    public void setImageBitmap(Bitmap bm) {
        mArticleImg.setImageBitmap(bm);
    }

    public void setText(CharSequence text) {
        mArticleTitle.setText(text);
    }

    public Drawable getDrawable() {
        return mArticleImg.getDrawable();
    }

    public CharSequence getText() {
        return mArticleTitle.getText();
    }

    public ImageView getImageView() {
        return mArticleImg;
    }

    public Article getArticle() {
        return mArticle;
    }

    public void setArticle(Article mArticle) {
        this.mArticle = mArticle;
    }

}
