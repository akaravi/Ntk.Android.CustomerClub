package ntk.android.customerclub;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

import es.dmoral.toasty.Toasty;
import ntk.android.base.ApplicationParameter;
import ntk.android.base.ApplicationStaticParameter;
import ntk.android.base.ApplicationStyle;
import ntk.android.base.NTKApplication;
import ntk.android.base.utill.FontManager;
import ntk.android.base.view.ViewController;
import ntk.android.customerclub.activity.MainActivity;
//import ntk.android.base.view.ViewController;


public class MyApplication extends NTKApplication {

    public static boolean Inbox = false;

    @Override
    public void onCreate() {
        super.onCreate();
        DEBUG = true;
        if (!new File(getCacheDir(), "image").exists()) {
            new File(getCacheDir(), "image").mkdirs();
        }
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .diskCache(new UnlimitedDiskCache(new File(getCacheDir(), "image")))
                .diskCacheFileNameGenerator(imageUri -> {
                    String[] Url = imageUri.split("/");
                    return Url[Url.length];
                })
                .build();
        ImageLoader.getInstance().init(config);

        Toasty.Config.getInstance()
                .setToastTypeface(FontManager.GetTypeface(getApplicationContext(), FontManager.IranSans))
                .setTextSize(14).apply();
        applicationStyle = new ApplicationStyle() {
            @Override
            public ViewController getViewController() {
                ViewController vc = new ViewController() {
                };
                vc.setLoading_view(R.layout.sub_base_loading)
                        .setEmpty_view(R.layout.sub_base_empty)
                        .setError_view(R.layout.sub_base_error)
                        .setError_button(R.id.btn_error_tryAgain)
                        .setError_label(R.id.tvError);
                return vc;
            }

            @Override
            public Class<?> getMainActivity() {
                return MainActivity.class;
            }

//            @Override
//            public ViewController getViewController() {
//                ViewController v = new ViewController() {
//                };
//                v.setError_view(R.layout.sub_base_error);
//                v.setLoading_view(R.layout.sub_base_loading);
//                v.setEmpty_view(R.layout.sub_base_empty);
//                return v;
//            }
        };
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    @Override
    protected ApplicationStaticParameter getConfig() {
        ApplicationStaticParameter applicationStaticParameter = new ApplicationStaticParameter();
//        ApplicationStaticParameter.URL = "http://fc8959d0a34d.ngrok.io";
        return applicationStaticParameter;
    }

    @Override
    public ApplicationParameter getApplicationParameter() {
        return new ApplicationParameter(BuildConfig.APPLICATION_ID, BuildConfig.APPLICATION_ID, BuildConfig.VERSION_NAME, BuildConfig.VERSION_CODE);
    }
}
