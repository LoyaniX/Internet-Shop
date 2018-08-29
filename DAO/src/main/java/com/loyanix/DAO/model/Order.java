package com.loyanix.DAO.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private User user;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ORDERS_PRODUCTS",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCTS_ID")
    )
    private Set<Product> products = new HashSet<>();

    @Column(name = "PRICE", nullable = false)
    private Integer orderPrice;

    @Column(name = "DATE_OF_CREATE", nullable = false)
    private Date dateOfCreate;

    @Column(name = "STATUS", nullable = false)
    private String status;

    public Order() {
    }

    public Order(Long id, User user, Set<Product> products, Integer orderPrice, Date dateOfCreate, String status) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.orderPrice = orderPrice;
        this.dateOfCreate = dateOfCreate;
        this.status = status;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Set<Product> getProducts() { return products; }

    public void setProducts(Set<Product> products) { this.products = products; }

    public Integer getOrderPrice() { return orderPrice; }

    public void setOrderPrice(Integer orderPrice) { this.orderPrice = orderPrice; }

    public Date getDateOfCreate() { return dateOfCreate; }

    public void setDateOfCreate(Date dateOfCreate) { this.dateOfCreate = dateOfCreate; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                ", orderPrice=" + orderPrice +
                ", dateOfCreate=" + dateOfCreate +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(user, order.user) &&
                Objects.equals(products, order.products) &&
                Objects.equals(orderPrice, order.orderPrice) &&
                Objects.equals(dateOfCreate, order.dateOfCreate) &&
                Objects.equals(status, order.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, products, orderPrice, dateOfCreate, status);
    }
}
