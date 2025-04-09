package com.example.quanlichitieu.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlichitieu.Model.Group;
import com.example.quanlichitieu.R;

import java.util.List;

public class GroupAdapter extends BaseAdapter {
    private Context context;
    private List<Group> groupList;

    public GroupAdapter(Context context, List<Group> groupList) {
        this.context = context;
        this.groupList = groupList;
    }

    @Override
    public int getCount() {
        return groupList.size();
    }

    @Override
    public Object getItem(int position) {
        return groupList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return groupList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Group group = groupList.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.avatarImageView);
        TextView nameView = convertView.findViewById(R.id.nameTextView);

        imageView.setImageResource(group.getImage());
        nameView.setText(group.getName());

        return convertView;
    }
}
