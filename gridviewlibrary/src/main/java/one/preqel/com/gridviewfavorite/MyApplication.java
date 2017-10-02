package one.preqel.com.gridviewfavorite;

import android.app.Application;

/**
 * Created by wangkang on 2017/1/11.
 */
public class MyApplication extends Application {

    private static  MyApplication application;

    public MyApplication(){
         application = this;
    }

    public static MyApplication getApplication() {
        return application;
    }
}
