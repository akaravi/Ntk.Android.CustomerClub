package ntk.android.customerclub.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ntk.android.base.adapter.BaseRecyclerAdapter;
import ntk.android.customerclub.R;
import ntk.android.customerclub.server.model.PayModel;

public class PayAdapter extends BaseRecyclerAdapter<PayModel, PayAdapter.VH> {
    public PayAdapter(List<PayModel> list) {
        super(list);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(inflate(parent, R.layout.row_recycler_class5));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {

    }

    public class VH extends RecyclerView.ViewHolder {
        public VH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
