package com.yl.hzylbase;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;

/*import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;*/

/**
 * @author Yang Shihao
 */
public class App extends Application {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        MultiDex.install(this);
    }

    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }


    //在手机上调整系统字体后，比如调大字体，App会样式错乱，并且与弹窗有关的UI均显示异常。
    // 如果不需要App内字体和UI随着系统字体的变化而改变
    //禁止app字体大小跟随系统字体大小调节
    @Override
    public Resources getResources() {
        Resources resources = super.getResources();
        if (resources != null && resources.getConfiguration().fontScale != 1.0f) {
            android.content.res.Configuration configuration = resources.getConfiguration();
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }


    public static App getInstance() {
        return app;
    }


    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
       /* SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> new ClassicsHeader(context));
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> new ClassicsFooter(context));*/
    }
}