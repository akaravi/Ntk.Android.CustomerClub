package ntk.android.customerclub.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ntk.android.base.adapter.BaseRecyclerAdapter;
import ntk.android.base.utill.FontManager;
import ntk.android.base.view.NViewUtils;
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
        ((TextView) holder.itemView.findViewById(R.id.buyTitle)).setText(getItem(position).Name);
        ((TextView) holder.itemView.findViewById(R.id.dateTxt)).setText(getItem(position).AccountId);
        ((TextView) holder.itemView.findViewById(R.id.tmeTxt)).setText(getItem(position).AccountType);
        ((TextView) holder.itemView.findViewById(R.id.priceTxt)).setText(NViewUtils.PriceFormat(getItem(position).price));
    }

    public class VH extends RecyclerView.ViewHolder {
        public VH(@NonNull View itemView) {
            super(itemView);
            ((TextView) itemView.findViewById(R.id.buyTitle)).setTypeface(FontManager.T1_Typeface(itemView.getContext()));
            ((TextView) itemView.findViewById(R.id.dateTxt)).setTypeface(FontManager.T1_Typeface(itemView.getContext()));
            ((TextView) itemView.findViewById(R.id.tmeTxt)).setTypeface(FontManager.T1_Typeface(itemView.getContext()));
            ((TextView) itemView.findViewById(R.id.priceTxt)).setTypeface(FontManager.T1_Typeface(itemView.getContext()));
        }
    }
}
