package com.example.quanlichitieu.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlichitieu.Model.LoiNhac;
import com.example.quanlichitieu.R;
import java.util.List;

public class LoiNhacAdapter extends RecyclerView.Adapter<LoiNhacAdapter.LoiNhacViewHolder> {
    private List<LoiNhac> loiNhacs;

    public LoiNhacAdapter(List<LoiNhac> loiNhacs) {
        this.loiNhacs = loiNhacs;
    }

    @NonNull
    @Override
    public LoiNhacViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loi_nhac, parent, false);
        return new LoiNhacViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoiNhacViewHolder holder, int position) {
        LoiNhac loiNhac = loiNhacs.get(position);
        holder.tvMoTa.setText(loiNhac.getMoTa());
        holder.tvNgayNhac.setText(loiNhac.getNgayNhac());
    }

    @Override
    public int getItemCount() {
        return loiNhacs.size();
    }

    public static class LoiNhacViewHolder extends RecyclerView.ViewHolder {
        TextView tvMoTa, tvNgayNhac;

        public LoiNhacViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMoTa = itemView.findViewById(R.id.tvLoiNhac);
//            tvNgayNhac = itemView.findViewById(R.id.tvNgayNhac);
        }
    }
}
