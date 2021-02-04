package ntk.android.customerclub.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

import ntk.android.customerclub.R;
import ntk.android.customerclub.server.model.CardModel;

public class LoanSelectAdapter extends ArrayAdapter<CardModel> {

    private final List<CardModel> list;

    public LoanSelectAdapter(@NonNull Context context, List<CardModel> arrayList) {
        super(context, R.layout.row_account_bank, arrayList);
        list = arrayList;
    }

    @Override
    public CardModel getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @NonNull
    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_account_bank, parent, false);
        }
        ((TextView) view.findViewById(R.id.textView)).setText(getItem(position).AccountId + "-" + getItem(position).Name);
        return view;
    }
}