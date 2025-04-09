package com.example.quanlichitieu.Model;
public class User {

    private int avatarResId;
    private Integer userId;

    private String userName;


    private String email;
    private String password;


    private String description;

    private String avatarUser;
    public User(String name, int avatarResId) {
        this.userName = name;
        this.avatarResId = avatarResId;
    }

    public String getName() {
        return userName;
    }

    public int getAvatarResId() {
        return avatarResId;
    }
}
