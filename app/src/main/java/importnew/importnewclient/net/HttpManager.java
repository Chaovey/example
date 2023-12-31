package importnew.importnewclient.net;

import android.content.Context;

import java.io.File;
import java.util.concurrent.TimeUnit;

import importnew.importnewclient.utils.AppUtil;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * HTTP connection management, singleton, globally only provides one OkhttpClient object
 * Created by Xingfeng on 2016/5/7.
 */
public class HttpManager {

    private static HttpManager instance = null;

    public static HttpManager getInstance(Context context) {

        if (instance == null) {
            synchronized (HttpManager.class) {
                if (instance == null) {
                    instance = new HttpManager(context.getApplicationContext());
                }
            }
        }
        return instance;

    }


    private OkHttpClient client;

    private HttpManager(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS).addInterceptor(new ArticleBodyInterceptor()).retryOnConnectionFailure(true);
        File cacheFile = AppUtil.getDiskCacheDir(context, "response");
        if (!cacheFile.exists()) {
            cacheFile.exists();
        }
        Cache cache = new Cache(cacheFile, 40 * 1024 * 1024);//40M响应缓存
        client = builder.cache(cache).build();
    }

    public OkHttpClient getClient() {
        return client;
    }

}
