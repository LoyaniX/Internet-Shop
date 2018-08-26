package com.loyanix.DAO.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "GENDER", nullable = false)
    private String gender;

    @Column(name = "COLOUR", nullable = false)
    private String colour;

    @Column(name = "SIZE", nullable = false)
    private String size;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @ManyToMany(targetEntity = Order.class)
    private Set<Order> orders;

    public Product() {
    }

    public Product(Long id, String name, Double price, String category, String gender,String colour, String size, Integer quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.gender = gender;
        this.colour = colour;
        this.size = size;
        this.quantity = quantity;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getGender() { return gender; }

    public void setGender(String gender) { this.gender = gender; }

    public String getColour() { return colour; }

    public void setColour(String colour) { this.colour = colour; }

    public String getSize() { return size; }

    public void setSize(String size) { this.size = size; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Set<Order> getOrders() { return orders; }

    public void setOrders(Set<Order> orders) { this.orders = orders; }

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
                Objects.equals(colour, product.colour) &&
                Objects.equals(size, product.size) &&
                Objects.equals(quantity, product.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category, gender, colour, size, quantity);
    }

    @Override
    public String toString() {
        return "Product{" +
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
