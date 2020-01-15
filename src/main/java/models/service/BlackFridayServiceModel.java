package models.service;

public class BlackFridayServiceModel {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private double minPrice;
    private double discount;
    private double discountedPrice;
    private String userUsername;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscountedPrice() {
        double discountedPrice = getPrice() * (1 - (getDiscount() * 0.01));
        if(getMinPrice() > discountedPrice){
            return getMinPrice();
        }else{
            return discountedPrice;
        }
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }
}
