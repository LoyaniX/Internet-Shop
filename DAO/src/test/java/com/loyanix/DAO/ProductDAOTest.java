package com.loyanix.DAO;

import com.loyanix.DAO.model.Product;
import com.loyanix.DAO.model.User;
import com.loyanix.DAO.repo.ProductDAO;
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
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context-dao-test.xml")
@Transactional
public class ProductDAOTest {

    @Autowired
    private ProductDAO productDAO;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    public  void cleanUp(){ entityManager.createQuery("DELETE FROM Product").executeUpdate(); }

    @Test
    public void testCreate(){

        //given
        Product product = new Product(null,"nike", 100, "short", "M", " red", "L", 10);
        //when
        productDAO.create(product);
        //then
        Product actualProduct = entityManager.find(Product.class, product.getId());
        Assert.assertEquals(product,actualProduct);
    }
    @Test
    public void testDelete(){

        //given
        Product product = new Product(null,"nike", 100, "short", "M", " red", "L", 10);
        entityManager.persist(product);
        //when
        Long id = product.getId();
        productDAO.delete(id);
        //then
        entityManager.clear();
        Product deletedProduct = entityManager.find(Product.class, id);
        Assert.assertNull(deletedProduct);

    }
    @Test
    public void testGetUser(){

        //given
        Product product = new Product(null,"nike", 100, "short", "M", " red", "L", 10);
        entityManager.persist(product);
        //when
        Product actualProduct = productDAO.get(product.getId());
        //then
        Assert.assertEquals(product,actualProduct);

    }
    @Test
    public void testUpdate(){

        //given
        Product product = new Product(null,"nike", 100, "short", "M", " red", "L", 10);
        entityManager.persist(product);
        Product newProduct = new Product(null,"adidas", 10, "short", "M", " red", "L", 10);
        //when
        productDAO.update(product.getId(), newProduct);
        //then
        Product updatedProduct = entityManager.find(Product.class,product.getId());
        Assert.assertEquals(product, updatedProduct);
    }
    @Test
    public void testFindAll(){

        //given
        Product product = new Product(null,"nike", 100, "short", "M", " red", "L", 10);
        Product product1 = new Product(null,"nike", 100, "short", "M", " red", "L", 10);
        Product product2 = new Product(null,"nike", 100, "short", "M", " red", "L", 10);
        Product product3 = new Product(null,"nike", 100, "short", "M", " red", "L", 10);
        Product product4 = new Product(null,"nike", 100, "short", "M", " red", "L", 10);
        entityManager.persist(product);
        entityManager.persist(product1);
        entityManager.persist(product2);
        entityManager.persist(product3);
        entityManager.persist(product4);
        List<Product> productsStart = Arrays.asList(product,product1,product2,product3,product4);
        //when
        List<Product> foundAll = productDAO.findAll();
        //then
        Assert.assertEquals(5, foundAll.size());
        Assert.assertTrue(productsStart.containsAll(foundAll));
    }
}
