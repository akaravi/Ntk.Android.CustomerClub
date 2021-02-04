package ntk.android.customerclub.server.service;

import android.content.Context;

import java.util.ArrayList;
import java.util.Map;

import io.reactivex.Observable;
import ntk.android.base.config.ConfigRestHeader;
import ntk.android.base.entitymodel.base.ErrorException;
import ntk.android.base.entitymodel.base.FilterModel;
import ntk.android.customerclub.server.model.PayModel;

public class PayService {
    private final Map<String, String> headers;
    String baseUrl = "api/v1/";
    String controlerUrl = "service";
    Context context;

    public PayService(Context context) {
        this.context = context;
        this.headers = (new ConfigRestHeader()).GetHeaders(context);
    }

    public Observable<ErrorException<PayModel>> getAll(FilterModel request) {
        return Observable.create(emitter -> {
            Thread.sleep(2000);
            ErrorException<PayModel> model = new ErrorException<>();
            model.IsSuccess = true;
            model.ListItems = new ArrayList<>();
            {
                PayModel a1 = new PayModel();
                a1.Name = "هایپر مارکت بهار";
                a1.AccountId = "1399/11/1";
                a1.AccountType = "23:33";
                a1.price = 340000;
                model.ListItems.add(a1);
            }
            {
                PayModel a1 = new PayModel();
                a1.Name = "هایپر مارکت میلاد";
                a1.AccountId = "1399/11/2";
                a1.AccountType = "13:36";
                a1.price = 7260000;
                model.ListItems.add(a1);
            }
            {
                PayModel a1 = new PayModel();
                a1.Name = "هایپر مارکت نوبهار";
                a1.AccountId = "1399/11/12";
                a1.AccountType = "05:11";
                a1.price = 1260000;
                model.ListItems.add(a1);
            }
            {
                PayModel a1 = new PayModel();
                a1.Name = "هایپر مارکت میلاد";
                a1.AccountId = "1399/11/14";
                a1.AccountType = "16:53";
                a1.price = 125000;
                model.ListItems.add(a1);
            }
            {
                PayModel a1 = new PayModel();
                a1.Name = "هایپر مارکت نوبهار";
                a1.AccountId = "1399/11/21";
                a1.AccountType = "03:33";
                a1.price = 1667000;
                model.ListItems.add(a1);
            }
            {
                PayModel a1 = new PayModel();
                a1.Name = "هایپر مارکت نوبهار";
                a1.AccountId = "1399/11/22";
                a1.AccountType = "12:19";
                a1.price = 327000;
                model.ListItems.add(a1);
            }
            model.TotalRowCount = 2;
            emitter.onNext(model);
            emitter.onComplete();
        });
    }


    public Observable<ErrorException<PayModel>> getPopularDestinationsAccount(FilterModel request) {
        return Observable.create(emitter -> {
            Thread.sleep(2000);
            ErrorException<PayModel> model = new ErrorException<>();
            model.IsSuccess = true;
            model.ListItems = new ArrayList<>();
            {
                PayModel a1 = new PayModel();
                a1.Name = "حسین متقی";
                a1.AccountId = "132423423562";
                a1.AccountType = "جاری";
                model.ListItems.add(a1);
            }
            {
                PayModel a1 = new PayModel();
                a1.Name = "حجت سلامی زاده";
                a1.AccountId = "1234333456789";
                a1.AccountType = "حساب مشترک";
                model.ListItems.add(a1);
            }
            {
                PayModel a1 = new PayModel();
                a1.Name = "حسین نامداری";
                a1.AccountId = "78678342";
                a1.AccountType = "حساب کوتاه مدت";
                model.ListItems.add(a1);
            }

            model.TotalRowCount = 2;
            emitter.onNext(model);
            emitter.onComplete();
        });
    }
}
