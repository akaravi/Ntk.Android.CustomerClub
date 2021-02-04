package ntk.android.customerclub.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ntk.android.base.adapter.BaseRecyclerAdapter;
import ntk.android.base.utill.FontManager;
import ntk.android.customerclub.R;
import ntk.android.customerclub.server.model.CardModel;

public class CardAdapter extends BaseRecyclerAdapter<CardModel, CardAdapter.VH> {
    public CardAdapter(List<CardModel> list) {
        super(list);
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(inflate(parent, R.layout.row_recycler_class6));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        ((TextView) holder.itemView.findViewById(R.id.txtId)).setText(getItem(position).Name);
        ((TextView) holder.itemView.findViewById(R.id.txtCount)).setText(getItem(position).AccountId);
        ((TextView) holder.itemView.findViewById(R.id.txtDate)).setText(getItem(position).Type);
    }

    public class VH extends RecyclerView.ViewHolder {
        public VH(@NonNull View itemView) {
            super(itemView);
            ((TextView) itemView.findViewById(R.id.txtId)).setTypeface(FontManager.T1_Typeface(itemView.getContext()));
            ((TextView) itemView.findViewById(R.id.txtCount)).setTypeface(FontManager.T1_Typeface(itemView.getContext()));
            ((TextView) itemView.findViewById(R.id.txtDate)).setTypeface(FontManager.T1_Typeface(itemView.getContext()));
        }
    }
}
