package com.loyanix.DAO.model;

import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private Double price;
    private String category;
    private String gender;
    private String size;
    private Integer quantity;

    public Product() {
    }

    public Product(Long id, String name, Double price, String category, String gender, String size, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.gender = gender;
        this.size = size;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(category, product.category) &&
                Objects.equals(gender, product.gender) &&
                Objects.equals(size, product.size) &&
                Objects.equals(quantity, product.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category, gender, size, quantity);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", gender='" + gender + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
