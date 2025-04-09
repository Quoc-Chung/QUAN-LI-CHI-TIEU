package com.example.quanlichitieu.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlichitieu.Model.ThongBao;
import com.example.quanlichitieu.R;

import java.util.List;

public class ThongBaoAdapter extends RecyclerView.Adapter<ThongBaoAdapter.ViewHolder> {
    private List<ThongBao> thongBaoList;

    public ThongBaoAdapter(List<ThongBao> thongBaoList) {
        this.thongBaoList = thongBaoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thong_bao, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ThongBao thongBao = thongBaoList.get(position);
        holder.imgAvatar.setImageResource(thongBao.getAvatar());
        holder.tvNoiDung.setText(thongBao.getNoiDung());
    }

    @Override
    public int getItemCount() {
        return thongBaoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView tvNoiDung;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            tvNoiDung = itemView.findViewById(R.id.tvNoiDung);
        }
    }
}