package com.loyanix.services.DTO;

import com.loyanix.DAO.model.Product;
import com.loyanix.DAO.model.User;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class OrderDTO {

    private Long id;
    private User user;
    private Set<Product> products;
    private Integer orderPrice;
    private Date dateOfCreate;
    private String status;

    public OrderDTO() {
    }

    public OrderDTO(Long id, User user, Set<Product> products, Integer orderPrice, Date dateOfCreate, String status) {
        this.id = id;
        this.user = user;
        this.products = products;
        this.orderPrice = orderPrice;
        this.dateOfCreate = dateOfCreate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
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
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id) &&
                Objects.equals(user, orderDTO.user) &&
                Objects.equals(products, orderDTO.products) &&
                Objects.equals(orderPrice, orderDTO.orderPrice) &&
                Objects.equals(dateOfCreate, orderDTO.dateOfCreate) &&
                Objects.equals(status, orderDTO.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, products, orderPrice, dateOfCreate, status);
    }
}
