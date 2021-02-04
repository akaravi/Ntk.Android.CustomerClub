package ntk.android.customerclub.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;
import com.mohamadamin.persianmaterialdatetimepicker.utils.PersianCalendar;

import io.reactivex.annotations.NonNull;
import ntk.android.base.activity.BaseActivity;
import ntk.android.base.config.NtkObserver;
import ntk.android.base.config.ServiceExecute;
import ntk.android.base.entitymodel.base.ErrorException;
import ntk.android.base.entitymodel.base.FilterModel;
import ntk.android.customerclub.R;
import ntk.android.customerclub.adapter.PayAdapter;
import ntk.android.customerclub.server.model.PayModel;
import ntk.android.customerclub.server.service.PayService;

public class Class5 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class5);
        ((TextView) findViewById(R.id.txtToolbar)).setText(getString(R.string.mainCard5));
        ((Button) findViewById(R.id.btnOk)).setText("گزارش");
        findViewById(R.id.btn_cancel).setOnClickListener(view -> finish());
        findViewById(R.id.back_button).setOnClickListener(view -> finish());
        findViewById(R.id.btnOk).setOnClickListener(view -> getPays());
        EditText fromDate = findViewById(R.id.etFromDate);
        fromDate.setFocusableInTouchMode(false);
        fromDate.setLongClickable(false);
        fromDate.setOnClickListener(view -> showFromDate());

        EditText toDate = findViewById(R.id.etToDate);
        toDate.setFocusableInTouchMode(false);
        toDate.setLongClickable(false);
        toDate.setOnClickListener(view -> showToDate());
    }


    private void getPays() {
        switcher.showProgressView();
        ServiceExecute.execute(new PayService(this).getAll(new FilterModel())).subscribe(new NtkObserver<ErrorException<PayModel>>() {
            @Override
            public void onNext(@NonNull ErrorException<PayModel> accountModelErrorException) {
                switcher.showContentView();
                PayAdapter adapter = new PayAdapter(accountModelErrorException.ListItems);
                RecyclerView rc = (RecyclerView) findViewById(R.id.recycler);
                rc.setLayoutManager(new LinearLayoutManager(Class5.this, RecyclerView.VERTICAL, false));
                rc.setAdapter(adapter);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                switcher.showErrorView(e.getMessage(), Class5.this::getPays);
            }
        });
    }

    public void showFromDate() {
        PersianCalendar persianCalendar = new PersianCalendar();
        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
                (view, year, monthOfYear, dayOfMonth) -> {
                    ((EditText) findViewById(R.id.etFromDate)).setText(year + "/" + monthOfYear + "/" + dayOfMonth);
                },
                persianCalendar.getPersianYear(),
                persianCalendar.getPersianMonth(),
                persianCalendar.getPersianDay()
        );
        datePickerDialog.show(getFragmentManager(), "Datepickerdialog");
    }
    public void showToDate() {
        PersianCalendar persianCalendar = new PersianCalendar();
        DatePickerDialog datePickerDialog = DatePickerDialog.newInstance(
                (view, year, monthOfYear, dayOfMonth) -> {
                    ((EditText) findViewById(R.id.etToDate)).setText(year + "/" + monthOfYear + "/" + dayOfMonth);
                },
                persianCalendar.getPersianYear(),
                persianCalendar.getPersianMonth(),
                persianCalendar.getPersianDay()
        );
        datePickerDialog.show(getFragmentManager(), "Datepickerdialog");
    }
}
