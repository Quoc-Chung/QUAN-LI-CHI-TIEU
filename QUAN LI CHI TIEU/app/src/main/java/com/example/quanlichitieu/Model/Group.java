package com.example.quanlichitieu.Model;


import java.util.List;

public class Group {
    private int id;
    private String name;
    private int image; // Resource ID (e.g. R.drawable.avatar)
    private List<String> members; // Danh sách tên thành viên

    public Group(int id, String name, int image, List<String> members) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.members = members;
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
