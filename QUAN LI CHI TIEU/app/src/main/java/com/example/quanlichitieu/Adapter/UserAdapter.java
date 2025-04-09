package com.example.quanlichitieu.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.quanlichitieu.Model.User;
import com.example.quanlichitieu.R;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    private Context context;
    private List<User> userList;

    public UserAdapter(Context context, List<User> userList) {
        super(context, 0, userList);
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = userList.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        }

        ImageView avatarImageView = convertView.findViewById(R.id.avatarImageView);
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);

        nameTextView.setText(user.getName());
        avatarImageView.setImageResource(user.getAvatarResId());

        return convertView;
    }
}
