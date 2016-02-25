package niejinkun.com.italytrain.base;

import android.content.Context;
import android.graphics.Color;

import com.facebook.stetho.Stetho;
import niejinkun.com.italytrain.BuildConfig;
import niejinkun.com.italytrain.R;
import niejinkun.com.italytrain.utils.StrictModeUtil;
import niejinkun.com.italytrain.utils.logger.LogLevel;
import niejinkun.com.italytrain.utils.logger.Logger;
import niejinkun.com.italytrain.view.imageloader.ImageLoadProxy;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class Application extends android.app.Application {

    public static int COLOR_OF_DIALOG = R.color.primary;
    public static int COLOR_OF_DIALOG_CONTENT = Color.WHITE;

    private static Context mContext;
 /*   private static DaoMaster daoMaster;
    private static DaoSession daoSession;*/

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        StrictModeUtil.init();
        super.onCreate();
        refWatcher = LeakCanary.install(this);
        mContext = this;
        ImageLoadProxy.initImageLoader(this);

        if (BuildConfig.DEBUG) {
            Logger.init().hideThreadInfo().setMethodCount(1).setLogLevel(LogLevel.FULL);
        }

        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());

    }

    public static Context getContext() {
        return mContext;
    }

    public static RefWatcher getRefWatcher(Context context) {
        Application application = (Application) context.getApplicationContext();
        return application.refWatcher;
    }


/*    public static DaoMaster getDaoMaster(Context context) {
        if (daoMaster == null) {
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, BaseCache.DB_NAME, null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    public static DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster(context);
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }*/

}