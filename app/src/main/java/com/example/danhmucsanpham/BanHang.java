package com.example.danhmucsanpham;

public class BanHang {
    private String name;
    private String  price;
    private String discount;
    private int image;

    public BanHang(String name, String price, String discount, int image) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
