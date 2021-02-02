package ntk.android.customerclub.activity;

import android.content.Intent;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import io.reactivex.Observable;
import java9.util.function.Function;
import ntk.android.base.activity.common.BaseFilterModelListActivity;
import ntk.android.base.entitymodel.base.ErrorException;
import ntk.android.base.entitymodel.base.FilterDataModel;
import ntk.android.base.entitymodel.news.NewsContentModel;
import ntk.android.base.services.news.NewsContentService;
import ntk.android.customerclub.R;
import ntk.android.customerclub.adapter.NewsAdapter;

public class NewsListActivity extends BaseFilterModelListActivity<NewsContentModel> {
    @Override
    protected void  onCreated() {
        super.onCreated();
        ((TextView) findViewById(R.id.lblTitle)).setText("اخبار");
    }

    @Override
    public Function<FilterDataModel, Observable<ErrorException<NewsContentModel>>> getService() {
        return new NewsContentService(this)::getAll;
    }


    @Override
    public RecyclerView.Adapter createAdapter() {
        return new NewsAdapter(this, models);
    }

    @Override
    public void ClickSearch() {
        startActivity(new Intent(this, NewsSearchActivity.class));
    }

}
