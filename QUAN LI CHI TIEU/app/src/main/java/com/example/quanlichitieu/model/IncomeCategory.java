package com.example.quanlichitieu.model;

public class IncomeCategory {
    private int incomeCategoryId;
    private String incomeCategoryName;
    private String imageUrl;

    public IncomeCategory(int incomeCategoryId, String incomeCategoryName, String imageUrl) {
        this.incomeCategoryId = incomeCategoryId;
        this.incomeCategoryName = incomeCategoryName;
        this.imageUrl = imageUrl;
    }

    public int incomeCategoryId() {
        return incomeCategoryId;
    }

    public void setIncomeCategoryId(int incomeCategoryId) {
        this.incomeCategoryId = incomeCategoryId;
    }

    public String incomeCategoryName() {
        return incomeCategoryName;
    }

    public void setIncomeCategoryName(String incomeCategoryName) {
        this.incomeCategoryName = incomeCategoryName;
    }

    public String imageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
