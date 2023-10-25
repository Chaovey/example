package importnew.importnewclient.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

import java.io.File;

/**
 * A tool class that obtains app information
 * Created by Xingfeng on 2016/5/7.
 */
public class AppUtil {

    /**
     * Obtain the path address of the hard disk cache based on the incoming filename
     *
     * @param context
     * @param filename
     * @return
     */
    public static File getDiskCacheDir(Context context, String filename) {

        boolean externalStorageAvailable = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);

        String cachePath;

        if (externalStorageAvailable) {
            File file = context.getExternalCacheDir();
            if (file == null) {
                cachePath = Environment.getDataDirectory().getPath();
            } else
                cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }

        return new File(cachePath + File.separator + filename);
    }

    /**
     * Gets the version number of the current application
     *
     * @param context
     * @return
     */
    public static int getAppVersion(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * Determine whether the network is in the Wifi state
     *
     * @return
     */
    public static boolean isWifi(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI)
            return true;
        else
            return false;

    }

}
