package ntk.android.customerclub.server.service;

import android.content.Context;

import java.util.ArrayList;
import java.util.Map;

import io.reactivex.Observable;
import ntk.android.base.config.ConfigRestHeader;
import ntk.android.base.entitymodel.base.ErrorException;
import ntk.android.base.entitymodel.base.FilterModel;
import ntk.android.customerclub.server.model.CardModel;

public class CardService {
    private final Map<String, String> headers;
    String baseUrl = "api/v1/";
    String controlerUrl = "service";
    Context context;

    public CardService(Context context) {
        this.context = context;
        this.headers = (new ConfigRestHeader()).GetHeaders(context);
    }

    public Observable<ErrorException<CardModel>> getAll(FilterModel request) {
        return Observable.create(emitter -> {
            Thread.sleep(2000);
            ErrorException<CardModel> model = new ErrorException<>();
            model.IsSuccess = true;
            model.ListItems = new ArrayList<>();
            {
                CardModel a1 = new CardModel();
                a1.Name = "وام خرید خودرو";
                a1.AccountId = "آیدین صلواتی-123456789";
                a1.Amount = 5000000;
                a1.payment = 50000;
                model.ListItems.add(a1);
            }
            {
                CardModel a1 = new CardModel();
                a1.Name = "آیدین صلواتی-وام جعاله";
                a1.AccountId = "آیدین صلواتی-123456789";
                a1.Amount = 5000000;     a1.payment = 50000;
                model.ListItems.add(a1);
            }
            model.TotalRowCount = 2;
            emitter.onNext(model);
            emitter.onComplete();
        });
    }


}
