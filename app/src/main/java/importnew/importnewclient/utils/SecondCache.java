package importnew.importnewclient.utils;

import android.content.Context;
import android.text.TextUtils;

import java.io.IOException;

import importnew.importnewclient.net.HttpManager;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Two-level caching for all web page requests
 * Network + hard disk cache
 * Created by Xingfeng on 2016/5/7.
 */
public class SecondCache {

    //Network cache + hard disk cache
    private OkHttpClient httpClient;

    public SecondCache(Context context) {
        //Network caching
        httpClient = HttpManager.getInstance(context).getClient();
    }

    /**
     * Get the response from the hard disk
     *
     * @param url
     * @return
     */
    private String getResponseFromDiskCache(String url) {

        Response response = null;
        try {
            Request request = new Request.Builder().cacheControl(CacheControl.FORCE_CACHE).url(url).build();
            Call call = httpClient.newCall(request);
            response = call.execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }

            return "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            if (response != null) {
                response.body().close();
            }
        }

    }

    /**
     * Get the response from the network and write the resulting response to the hard disk cache
     *
     * @param url
     * @return
     */
    public String getResponseFromNetwork(String url) {

        Response response = null;
        try {
            Request request = new Request.Builder().url(url).cacheControl(
                    new CacheControl.Builder().noCache().build()
            ).build();
            Call call = httpClient.newCall(request);
            response = call.execute();
            if (response.isSuccessful()) {

                return response.body().string();

            } else {
                return "";
            }

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        } finally {
            if (response != null) {
                response.body().close();
            }
        }
    }

    public String getResponseString(String url) {

        //Step 1：Get the response from the cache
        String result = getResponseFromDiskCache(url);
        //Step 2: Get a response from the network
        if (TextUtils.isEmpty(result))
            result = getResponseFromNetwork(url);
        return result;
    }

    public Response getResponse(String url) {
        try {
            Request request = new Request.Builder().url(url).cacheControl(
                    new CacheControl.Builder().noCache().build()
            ).build();
            Call call = httpClient.newCall(request);
            Response response = call.execute();
            if (response.isSuccessful()) {
                return response;
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
