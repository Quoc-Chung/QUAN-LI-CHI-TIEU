package com.example.quanlichitieu.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlichitieu.R;

public class GridAdapter extends BaseAdapter {
    private final Context context;
    private final String[] categoryNames;
    private final int[] categoryIcons;

    public GridAdapter(Context context, String[] categoryNames, int[] categoryIcons) {
        this.context = context;
        this.categoryNames = categoryNames;
        this.categoryIcons = categoryIcons;
    }

    @Override
    public int getCount() {
        return categoryNames.length;
    }

    @Override
    public Object getItem(int position) {
        return categoryNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false);
        }

        ImageView icon = convertView.findViewById(R.id.item_icon);
        TextView name = convertView.findViewById(R.id.item_title);

        icon.setImageResource(categoryIcons[position]);
        name.setText(categoryNames[position]);
        convertView.setOnClickListener(v -> {
            if (categoryNames[position].equals("Thêm")) {
                showDialogThemNhom();
            } else {
                // Nếu là nhóm khác thì có thể xử lý gì đó (mở danh sách giao dịch...)
            }
        });

        return convertView;
    }


    private void showDialogThemNhom() {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_them_nhom);

        EditText edtTenNhom = dialog.findViewById(R.id.edtTenNhom);
        Button btnChonAnh = dialog.findViewById(R.id.btnChonAnh);
        Button btnHuy = dialog.findViewById(R.id.btnHuy);
        Button btnLuu = dialog.findViewById(R.id.btnLuu);
        ImageView imgNhom = dialog.findViewById(R.id.imgNhom);
        TextView txtLoai = dialog.findViewById(R.id.txtLoai);

        btnChonAnh.setOnClickListener(v -> {
            // Thêm code chọn ảnh từ thư viện
        });

        btnHuy.setOnClickListener(v -> dialog.dismiss());

        btnLuu.setOnClickListener(v -> {
            String tenNhom = edtTenNhom.getText().toString().trim();
            if (tenNhom.isEmpty()) {
                edtTenNhom.setError("Vui lòng nhập tên nhóm!");
            } else {
                // Thực hiện lưu vào database
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

}
