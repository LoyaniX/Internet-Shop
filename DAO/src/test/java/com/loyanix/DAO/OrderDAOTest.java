package com.loyanix.DAO;

import com.loyanix.DAO.model.Order;
import com.loyanix.DAO.model.Product;
import com.loyanix.DAO.model.User;
import com.loyanix.DAO.repo.OrderDAO;
import com.loyanix.DAO.repo.ProductDAO;
import com.loyanix.DAO.repo.UserDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context-dao-test.xml")
@Transactional
public class OrderDAOTest {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ProductDAO productDAO;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    public void cleanUp(){
        entityManager.createQuery("DELETE FROM Order").executeUpdate();
    }

    @Test
    public void testCreate(){
        //given
        Set<Product> products = new HashSet<>();
        products.add(productDAO.get(1L));
        products.add(productDAO.get(2L));
        User user = userDAO.get(1L);
        Date date = new Date();
        Order order = new Order(null, user, products,100, date,"testing");
        //when
        orderDAO.create(order);
        //than
        Order actualOrder = entityManager.find(Order.class, order.getId());
        Assert.assertEquals(order, actualOrder);
    }

    @Test
    public void testDelete(){
        //given
        Set<Product> products = new HashSet<>();
        products.add(productDAO.get(1L));
        products.add(productDAO.get(2L));
        User user = userDAO.get(1L);
        Date date = new Date();
        Order order = new Order(null, user, products,100, date,"testing");
        entityManager.persist(order);
        //when
        orderDAO.delete(order.getId());
        //than
        entityManager.clear();
        Assert.assertNull(entityManager.find(Order.class, order.getId()));
    }
    @Test
    public void testUpdate(){
        //given
        Set<Product> products = new HashSet<>();
        Set<Product> products1 = new HashSet<>();
        products.add(productDAO.get(1L));
        products.add(productDAO.get(2L));
        products1.add(productDAO.get(3L));
        User user = userDAO.get(1L);
        Date date = new Date();
        Order order = new Order(null, user, products,100, date,"testing");
        entityManager.persist(order);
        Order newOrder = new Order(null, userDAO.get(2L), products1, 10, date,"newTesting");
        //when
        orderDAO.update(order.getId(), newOrder);
        //then
        Order actualOrder = entityManager.find(Order.class, order.getId());
        Assert.assertEquals(newOrder, actualOrder);
    }

    @Test
    public void testGet(){
        //given
        Set<Product> products = new HashSet<>();
        products.add(productDAO.get(1L));
        products.add(productDAO.get(2L));
        User user = userDAO.get(1L);
        Date date = new Date();
        Order order = new Order(null, user, products,100, date,"testing");
        entityManager.persist(order);
        //when
        Order actualOrder = orderDAO.get(order.getId());
        //then
        Assert.assertEquals(order, actualOrder);
    }

    @Test
    public void testFindAll(){
        //given
        Set<Product> products = new HashSet<>();
        Set<Product> products1 = new HashSet<>();
        Set<Product> products2 = new HashSet<>();
        Set<Product> products3 = new HashSet<>();
        Set<Product> products4 = new HashSet<>();
        products.add(productDAO.get(1L));
        products.add(productDAO.get(2L));
        products1.add(productDAO.get(1L));
        products1.add(productDAO.get(2L));
        products2.add(productDAO.get(1L));
        products2.add(productDAO.get(2L));
        products3.add(productDAO.get(1L));
        products3.add(productDAO.get(2L));
        products4.add(productDAO.get(1L));
        products4.add(productDAO.get(2L));
        User user = userDAO.get(1L);
        User user1 = userDAO.get(2L);
        User user2 = userDAO.get(3L);
        User user3 = userDAO.get(2L);
        User user4 = userDAO.get(1L);
        Date date = new Date();
        Order order = new Order(null, user, products,100, date,"testing");
        Order order1 = new Order(null, user1, products1,100, date,"testing");
        Order order2 = new Order(null, user2, products2,100, date,"testing");
        Order order3 = new Order(null, user3, products3,100, date,"testing");
        Order order4 = new Order(null, user4, products4,100, date,"testing");
        entityManager.persist(order);
        entityManager.persist(order1);
        entityManager.persist(order2);
        entityManager.persist(order3);
        entityManager.persist(order4);
        List<Order> ordersStart = Arrays.asList(order,order1,order2,order3,order4);
        //when
        List<Order> foundAll = orderDAO.findAll();
        //then
        Assert.assertEquals(5,foundAll.size());
        Assert.assertTrue(ordersStart.containsAll(foundAll));
    }

    @Test
    public void testFindAllOrdersOfUser(){
        //given
        Set<Product> products = new HashSet<>();
        products.add(productDAO.get(1L));
        products.add(productDAO.get(2L));
        Set<Product> products1 = new HashSet<>();
        products1.add(productDAO.get(4L));
        products1.add(productDAO.get(3L));
        User user = userDAO.get(2L);
        Date date = new Date();
        Order order = new Order(null, user, products,100, date,"testing");
        Order order1 = new Order(null, user, products1,100, date,"testing");
        List<Order> ordersStart = Arrays.asList(order, order1);
        entityManager.persist(order);
        entityManager.persist(order1);
        //when
        List<Order> actualOrdersOfUser = orderDAO.findAllOrdersOfUser(user);
        //then
        Assert.assertEquals(2, actualOrdersOfUser.size());
        Assert.assertTrue(ordersStart.containsAll(actualOrdersOfUser));

    }

}
