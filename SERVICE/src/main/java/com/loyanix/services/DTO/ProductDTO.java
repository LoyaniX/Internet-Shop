package com.loyanix.services.DTO;

public class ProductDTO {
    private Long id;
    private String name;
    private Integer price;
    private String category;
    private String gender;
    private String colour;
    private String size;
    private Integer quantity;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, Integer price, String category, String gender,String colour, String size, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.gender = gender;
        this.colour = colour;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
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

    public String getColour() { return colour; }

    public void setColour(String colour) { this.colour = colour; }

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
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", gender='" + gender + '\'' +
                ", colour='" + colour + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
