package com.example.quanlichitieu.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quanlichitieu.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class NotificationBottomSheetFragment extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_notification, container, false);

        view.findViewById(R.id.option_delete).setOnClickListener(v -> {
            Toast.makeText(getContext(), "Xóa", Toast.LENGTH_SHORT).show();
            dismiss();
        });

        view.findViewById(R.id.option_mark_all_read).setOnClickListener(v -> {
            Toast.makeText(getContext(), "Đánh dấu tất cả đã đọc", Toast.LENGTH_SHORT).show();
            dismiss();
        });

        view.findViewById(R.id.option_share).setOnClickListener(v -> {
            Toast.makeText(getContext(), "Chia sẻ", Toast.LENGTH_SHORT).show();
            dismiss();
        });

        view.findViewById(R.id.option_help).setOnClickListener(v -> {
            Toast.makeText(getContext(), "Trợ giúp và phản hồi", Toast.LENGTH_SHORT).show();
            dismiss();
        });

        return view;
    }
}
