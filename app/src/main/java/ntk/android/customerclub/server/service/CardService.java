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
                a1.Name = "123568679456789";
                a1.AccountId = "نامحدود";
                a1.Type = "1399/02/12";
                model.ListItems.add(a1);
            }
            {
                CardModel a1 = new CardModel();
                a1.Name = "12899993456789";
                a1.AccountId = "نامحدود";
                a1.Type = "1399/05/17";
                model.ListItems.add(a1);
            }
            {
                CardModel a1 = new CardModel();
                a1.Name = "12345355663339";
                a1.AccountId = "محدود- 2 مرتبه";
                a1.Type = "1399/05/17";
                model.ListItems.add(a1);
            }
            {
                CardModel a1 = new CardModel();
                a1.Name = "66798878456789";
                a1.AccountId = "محدود- 1 مرتبه";
                a1.Type = "1399/05/17";
                model.ListItems.add(a1);
            }

            model.TotalRowCount = 2;
            emitter.onNext(model);
            emitter.onComplete();
        });
    }


}
